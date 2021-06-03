/*package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
public class AddressConsumer {

    @RabbitListener(queues =RabbitMqConfig.QUEUE)
    public void consumeMessageFromQueue(Address address) {
        System.out.println("Message recieved from queue : " + address);
    }
}*/