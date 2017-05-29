package com.itis.controller.websocket;

import com.itis.model.Message;
import com.itis.service.MessageService;
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

    @Autowired
    public MessageController(MessageService messageService, SimpMessageSendingOperations messageTemplate) {
        this.messageService = messageService;
        this.messageTemplate = messageTemplate;
    }

    @SubscribeMapping(ApplicationUrls.WebSocketsUrls.MESSAGES_PREVIEW_URL)
    public List<Message> getPreviews(final Principal principal) {
        return messageService.getPreview(principal.getName());
    }

    @SubscribeMapping(ApplicationUrls.WebSocketsUrls.MESSAGES_FROM_USER_URL)
    public List<Message> getMessages(final @DestinationVariable String user, final Principal principal) {
        return messageService.getMessages(user, principal.getName());
    }

    @MessageMapping(ApplicationUrls.WebSocketsUrls.BASE_MESSAGES_URL)
    public void sendMessage(final Message message, final Principal principal) {
        message.setFromUser(principal.getName());
        messageService.save(message);
        messageTemplate.convertAndSendToUser(
                message.getToUser(), ApplicationUrls.WebSocketsUrls.MESSAGES_QUEUE_URL, message);
    }

    @MessageMapping(ApplicationUrls.WebSocketsUrls.READ_MESSAGE_URL)
    public void readMessage(final @DestinationVariable Long id) {
        messageService.read(id);
    }
}
