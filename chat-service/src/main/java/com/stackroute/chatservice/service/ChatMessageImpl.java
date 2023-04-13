package com.stackroute.chatservice.service;

import com.stackroute.chatservice.exception.ResourceNotFoundException;
import com.stackroute.chatservice.model.ChatMessage;
import com.stackroute.chatservice.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMessageImpl implements ChatMessageService {
    private ChatMessageRepository repository;
    private ChatRoomService chatRoomService;

    @Autowired
    public ChatMessageImpl(ChatMessageRepository repository, ChatRoomService chatRoomService){
        this.repository = repository;
        this.chatRoomService =chatRoomService;
    }

    @Override
    public ChatMessage saveMessage(ChatMessage chatMessage) {
        repository.save(chatMessage);
        return chatMessage;
    }

    @Override
    public List<ChatMessage> findChatMessages(String senderId, String receiverId) {
        if (chatRoomService.getChatId(senderId,receiverId,false).isPresent()){
            String chatId = chatRoomService.getChatId(senderId,receiverId,false).get();
            return repository.findByChatId(chatId);
        }
       else {
            return new ArrayList<>();
        }
    }

    @Override
    public ChatMessage findMessageById(String id) {
        return repository
                .findById(id)
                .map(chatMessage -> {
                    return repository.save(chatMessage);
                })
                .orElseThrow(() ->
                        new ResourceNotFoundException("can't find message (" + id + ")"));
    }
}

