package com.itis.service;

import com.itis.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getPreview(final String username);

    List<Message> getMessages(final String from, final String to);

    void read(final Long id);

    Message save(final Message message);

    Message getById(Long id);
}
