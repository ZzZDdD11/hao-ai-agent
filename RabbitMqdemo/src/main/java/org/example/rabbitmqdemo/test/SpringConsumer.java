package org.example.rabbitmqdemo.test;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SpringConsumer {

    @RabbitListener(queues = "my-spring-queue")
    public void receiveMessage(String message){
        System.out.println("recived" + message);
    }


}
