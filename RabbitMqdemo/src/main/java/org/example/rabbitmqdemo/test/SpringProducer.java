package org.example.rabbitmqdemo.test;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SpringProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public  void sendMessage(String message) {
        rabbitTemplate.convertAndSend("my-spring-queue", message);
        System.out.println("send the message" + message);
    }
}
