package com.example.rabit_mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean public Queue queue()
    {
        return new Queue("queue-name", false);
    }

    @Bean public Exchange exchange()
    {
        return new DirectExchange("my-exchange");
    }

    @Bean
    public Binding binding(Queue queue, Exchange exchange)
    {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("routing-key")
                .noargs();
    }
}