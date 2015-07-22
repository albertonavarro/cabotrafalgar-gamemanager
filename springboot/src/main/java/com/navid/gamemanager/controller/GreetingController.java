package com.navid.gamemanager.controller;

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
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/events/{game}")
    public void greeting3(@DestinationVariable String game, Hello message, @Headers Map<String, String> headers) throws Exception {
        messagingTemplate.convertAndSend("/topic/game", message);
    }

}