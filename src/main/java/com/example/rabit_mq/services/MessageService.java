package com.example.rabit_mq.services;

import com.example.rabit_mq.component.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    public void processAndSendMessage(String messageContent) {
        // You can process the message if needed
        String processedMessage = messageContent.toUpperCase(); // Example of processing

        // Send the message to RabbitMQ
        rabbitMQProducer.sendMessage(processedMessage);
    }
}
