package com.navid.gamemanager.websocket;

import com.navid.gamemanager.events.AbstractEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
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