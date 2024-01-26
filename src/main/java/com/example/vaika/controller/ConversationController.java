package com.example.vaika.controller;

import com.example.vaika.modele.Conversation;
import com.example.vaika.modele.Message;
import com.example.vaika.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/message")
public class ConversationController {

    private final ConversationService conversationService;

    @Autowired
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }



    @GetMapping("/conversation/{id1}/{id2}")
    public Conversation createConversation(@PathVariable(value = "id1") String p1,@PathVariable(value = "id2") String p2) {
        return conversationService.createConversation(p1,p2);
    }


    @PostMapping("/{conversationId}/messages")
    public Conversation addMessageToConversation(@PathVariable String conversationId, @RequestBody Message message) {
        return conversationService.addMessageToConversation(conversationId, message);
    }


    @GetMapping("/conversations/{userId}")
    public List<Conversation> getConversationsByUserId(@PathVariable(value = "userId") String userId){
        return conversationService.getConversationsByUserId(userId);
    }

    @GetMapping("/conversation/{id}")
    public Optional<Conversation> getConversationById(@PathVariable(value = "id") String id){
        return   conversationService.getConversationById(id);

    }


}

