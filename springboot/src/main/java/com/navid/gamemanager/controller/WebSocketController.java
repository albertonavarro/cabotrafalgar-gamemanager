package com.navid.gamemanager.controller;

import com.navid.gamemanager.events.AbstractEvent;
import com.navid.gamemanager.websocket.Greetings;
import com.navid.gamemanager.websocket.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Map;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/events/{game}")
    public void sendMessage(@DestinationVariable String game, AbstractEvent message, @Headers Map<String, String> headers) throws Exception {
        messagingTemplate.convertAndSend("/topic/game/"+game, message);
    }

}