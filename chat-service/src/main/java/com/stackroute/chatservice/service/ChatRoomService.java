package com.stackroute.chatservice.service;

import java.util.Optional;

public interface ChatRoomService {
    public Optional<String> getChatId(String senderId, String receiverId, boolean ifIdExist);
}
