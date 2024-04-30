package com.chat.app.chatap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// configeing the websocket and providing the incoming and outgoing urls
@Configuration
@EnableWebSocketMessageBroker
public class Config implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");

        WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
    }

    // creating a url to make common pathway from API and frontend
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry.addEndpoint("/server1").withSockJS();

        WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
    }
    
}
