package com.stackroute.chatservice.repository;

import com.stackroute.chatservice.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage,String> {
    long countBySenderIdAndReceiverId(String senderId, String receiverId);
    List<ChatMessage> findByChatId(String chatId);
}
