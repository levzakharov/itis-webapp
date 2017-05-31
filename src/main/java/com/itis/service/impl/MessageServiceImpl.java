package com.itis.service.impl;

import com.itis.model.Message;
import com.itis.repository.MessageRepository;
import com.itis.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository repository;

    @Autowired
    public MessageServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Message> getPreview(final String username) {
        return repository.getPreview(username);
    }

    @Override
    public List<Message> getMessages(final String from, final String to) {
        return repository.findByFromUserAndToUser(from, to);
    }

    @Override
    public void read(final Long id) {
        final Message message = repository.findOne(id);
        message.setUnread(false);
        repository.save(message);
    }

    @Override
    public Message save(final Message message) {
        return repository.save(message);
    }

    @Override
    public Message getById(Long id) {
        return repository.findOne(id);
    }
}
