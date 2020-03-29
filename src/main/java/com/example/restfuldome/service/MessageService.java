package com.example.restfuldome.service;

import com.example.restfuldome.pojo.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();
    Message findOne(Long id);
    void delete(Long id);
    Message update(Message message);
    Message updateText(Message message);
    Message save(Message message);
}
