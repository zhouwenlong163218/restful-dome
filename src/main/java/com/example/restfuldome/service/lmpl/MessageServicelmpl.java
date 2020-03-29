package com.example.restfuldome.service.lmpl;

import com.example.restfuldome.pojo.Message;
import com.example.restfuldome.repository.MessageRepository;
import com.example.restfuldome.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageServicelmpl implements MessageService {
    @Autowired
    private MessageRepository repository;
    @Override
    public List<Message> findAll(){
        return  repository.findAll();
    }
    @Override
    public Message findOne(Long id){
        return  repository.findOne(id);
    }
    @Override
    public void delete(Long id){
        repository.delete(id);
    }
    @Override
    public Message update(Message message){
        return repository.update(message);
        }
     @Override
    public Message updateText(Message message){
        return repository.updateText(message);
    }

    @Override
    public Message save(Message message) {
        return repository.save(message);
    }
}
