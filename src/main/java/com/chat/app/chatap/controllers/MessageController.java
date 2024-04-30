package com.chat.app.chatap.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.chatap.models.Message;

// controller craeted to handle recieve and send messages
@RestController
public class MessageController {

    // recieves message from frontend and return s to the callback API using websocket
    @MessageMapping("/message")
    @SendTo("/topic/return-to")
    public Message getMessage(@RequestBody Message message){
        // creating a little bit delay to redirect message to make it more relistic
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("ayush"+message.getName());

        return message;
    }
}
