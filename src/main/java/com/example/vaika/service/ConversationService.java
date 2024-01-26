package com.example.vaika.service;

import com.example.vaika.exception.ConversationNotFoundException;
import com.example.vaika.modele.Conversation;
import com.example.vaika.modele.Message;
import com.example.vaika.repo.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;

    @Autowired
    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public Conversation createConversation(String p1, String p2) {
        // Logique de création de conversation, par exemple, en utilisant le repository
        // Assurez-vous que les participants existent dans votre système d'utilisateurs
        Conversation conversation = new Conversation();
        List<String> participantIds = Arrays.asList(p1, p2);
        conversation.setParticipants(participantIds);
        return conversationRepository.save(conversation);
    }
//65b2c8a39873a6734de22279
    public Conversation addMessageToConversation(String conversationId, Message message) {
        // Logique d'ajout de message à une conversation
        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new ConversationNotFoundException("Conversation not found"));
        conversation.getMessages().add(message);
        return conversationRepository.save(conversation);
    }

    public List<Conversation> getConversationsByUserId(String userId){
        List<Conversation> conversations = conversationRepository.findByParticipantsContaining(userId);
        return conversations;
    }

    public Optional<Conversation> getConversationById(String id){
        return conversationRepository.findById(id);
    }
//

    // Autres méthodes de service pour récupérer les conversations, les messages, etc.

}
