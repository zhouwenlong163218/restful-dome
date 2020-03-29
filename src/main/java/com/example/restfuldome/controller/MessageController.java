package com.example.restfuldome.controller;

import com.example.restfuldome.common.ExceptionType;
import com.example.restfuldome.exception.CustomException;
import com.example.restfuldome.pojo.Message;
import com.example.restfuldome.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("/message")
    public ResponseEntity<List<Message>> List(){
        List<Message> list =this.messageService.findAll();
        if(!list.isEmpty()){
            return  ResponseEntity.ok(list);
        }
        else {
            return  ResponseEntity.noContent().build();
        }
    }
    @PostMapping("/message")
    public ResponseEntity<Message> create(Message message){
        Message msg = this.messageService.save(message);
        return ResponseEntity.ok(msg);
    }
    @PostMapping("/message")
    public ResponseEntity<Message> modify(Message message){
        Message msg = this.messageService.update(message);
        return ResponseEntity.ok(msg);
    }
    @PostMapping("/message/text")
    public ResponseEntity<Message> patch(Message message){
//        if(message == null || message.getText() ==null ||message.getText().isEmpty()){
//            throw new CustomException(ExceptionType.USER_INPUT_ERROR);
//        }
//        try {
//            Message msg =this.messageService.updateText(message);
//            return ResponseEntity.ok(msg);
//        } catch (Exception e){
//            e.
//        }
        Message msg = this.messageService.updateText(message);
        return ResponseEntity.ok(msg);
    }
    @GetMapping("/message/{id}")
    public ResponseEntity<Message> get(@PathVariable Long id){
        Message msg = this.messageService.findOne(id);
        return ResponseEntity.ok(msg);
    }
   @DeleteMapping("/message/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        this.messageService.delete(id);
        return ResponseEntity.noContent().build();
   }
}
