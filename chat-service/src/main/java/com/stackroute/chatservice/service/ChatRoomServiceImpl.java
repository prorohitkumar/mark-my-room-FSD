package com.stackroute.chatservice.service;

import com.stackroute.chatservice.model.ChatRoom;
import com.stackroute.chatservice.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ChatRoomServiceImpl implements ChatRoomService{
    private ChatRoomRepository repository;
    @Autowired
    public ChatRoomServiceImpl(ChatRoomRepository repository){
        this.repository = repository;
    }
    @Override
    public Optional<String> getChatId(String senderId, String receiverId, boolean ifIdExist) {

        return repository
                .findBySenderIdAndReceiverId(senderId, receiverId)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if(!ifIdExist) {
                        return  Optional.empty();
                    }
                    UUID generatedChatId = UUID.randomUUID();
                    String chatId = generatedChatId.toString();

                    ChatRoom senderRecipient = ChatRoom
                            .builder()
                            .chatId(chatId)
                            .senderId(senderId)
                            .receiverId(receiverId)
                            .build();

                    ChatRoom recipientSender = ChatRoom
                            .builder()
                            .chatId(chatId)
                            .senderId(receiverId)
                            .receiverId(senderId)
                            .build();
                    repository.save(senderRecipient);
                    repository.save(recipientSender);

                    return Optional.of(chatId);
                });

//        return Optional.empty();
    }
}
