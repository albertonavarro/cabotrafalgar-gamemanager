package com.navid.gamemanager.controller;

import com.navid.gamemanager.websocket.Greetings;
import com.navid.gamemanager.websocket.Hello;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greetings greeting(Hello message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greetings("Hello, " + message.getName() + "!");
    }

}