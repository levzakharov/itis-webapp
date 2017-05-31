package com.itis.controller.websocket;

import com.itis.model.Message;
import com.itis.model.User;
import com.itis.model.enums.Role;
import com.itis.service.MessageService;
import com.itis.service.UserService;
import com.itis.utils.ApplicationUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;

import java.util.List;

@Controller
public class MessageController {
    private final MessageService messageService;
    private final SimpMessageSendingOperations messageTemplate;
    private final UserService userService;

    @Autowired
    public MessageController(MessageService messageService, SimpMessageSendingOperations messageTemplate, UserService userService) {
        this.messageService = messageService;
        this.messageTemplate = messageTemplate;
        this.userService = userService;
    }

    @SubscribeMapping(ApplicationUrls.WebSocketsUrls.MESSAGES_PREVIEW_URL)
    public List<User> getPreviews(final Principal principal) {
        User user = userService.getByEmail(principal.getName());
        return userService.getAll();
    }

    @SubscribeMapping(ApplicationUrls.WebSocketsUrls.MESSAGES_FROM_USER_URL)
    public List<Message> getMessages(final @DestinationVariable String user, final Principal principal) {
        User userC = userService.getByEmail(principal.getName());
        if (userC.getRoles().contains(Role.WORKER)){
            List<Message> list1 = messageService.getMessages(user, "dean");
            List<Message> list2 = messageService.getMessages("dean", user);
            list1.addAll(list2);
            return list1;
        }
        else {
            List<Message> list1 = messageService.getMessages(user, principal.getName());
            List<Message> list2 = messageService.getMessages(principal.getName(), user);
            list1.addAll(list2);
            return list1;
        }
    }

    @MessageMapping(ApplicationUrls.WebSocketsUrls.BASE_MESSAGES_URL)
    public void sendMessage(final Message message, final Principal principal) {
        User user = userService.getByEmail(principal.getName());
        if (!user.getRoles().contains(Role.WORKER)) {
            message.setToUser("dean");
            message.setFromUser(principal.getName());
        }
        else
            message.setFromUser("dean");
        messageService.save(message);
        messageTemplate.convertAndSend(ApplicationUrls.WebSocketsUrls.MESSAGES_QUEUE_URL, message);
        if (message.getToUser().equals("dean")){//деканату
            messageTemplate.convertAndSendToUser(message.getFromUser(), ApplicationUrls.WebSocketsUrls.MESSAGES_QUEUE_URL, message);
        }
        else {//студенту
            messageTemplate.convertAndSendToUser(message.getToUser(), ApplicationUrls.WebSocketsUrls.MESSAGES_QUEUE_URL, message);

        }
    }

    @MessageMapping(ApplicationUrls.WebSocketsUrls.READ_MESSAGE_URL)
    public void readMessage(final @DestinationVariable Long id, final Principal principal) {
        messageService.read(id);
        Message message = messageService.getById(id);
        if (message.getToUser().equals("dean")){//деканату
            messageTemplate.convertAndSendToUser(message.getFromUser(),ApplicationUrls.WebSocketsUrls.MESSAGES_READEN_QUEUE_URL, id);
        }
        else {//студенту
            messageTemplate.convertAndSend(ApplicationUrls.WebSocketsUrls.MESSAGES_READEN_QUEUE_URL, id);
        }

    }
}
