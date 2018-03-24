package br.com.edsontofolo.webchat.chat.controller;

import br.com.edsontofolo.webchat.chat.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

/**
 * Created by Edson on 10/03/2018.
 */
@Controller
public class ChatController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        if (chatMessage.getReceiver().isEmpty()) {
            // Add username in web socket session
            headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        } else {
            messagingTemplate.convertAndSendToUser(chatMessage.getReceiver(), "/topic/public", chatMessage);
        }
        return chatMessage;
    }
}