package com.stackroute.chatservice.controller;

import com.stackroute.chatservice.model.ChatMessage;
import com.stackroute.chatservice.model.ChatRoom;
import com.stackroute.chatservice.service.ChatMessageService;
import com.stackroute.chatservice.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatController {
     private ChatMessageService chatMessageService;
     private ChatRoomService chatRoomService;
     private SimpMessagingTemplate messagingTemplate;
     @Autowired
     public ChatController(ChatMessageService chatMessageService, ChatRoomService chatRoomService, SimpMessagingTemplate messagingTemplate){
         this.chatMessageService = chatMessageService;
         this.chatRoomService = chatRoomService;
         this.messagingTemplate = messagingTemplate;
     }

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage){
        String chatId = chatRoomService
                .getChatId(chatMessage.getSenderId(), chatMessage.getReceiverId(), true).get();
        chatMessage.setChatId(chatId);

        ChatMessage savedMessage = chatMessageService.saveMessage(chatMessage);
        messagingTemplate.convertAndSendToUser(chatMessage.getSenderId(),"/queue/messages", savedMessage);
    }

    @GetMapping("/messages/{senderId}/{receiverId}")
    public ResponseEntity<?> findChatMessages (@PathVariable String senderId, @PathVariable String receiverId){
        return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, receiverId));
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<?> findMessage ( @PathVariable String id) {
        return ResponseEntity.ok(chatMessageService.findMessageById(id));
    }
}
