package com.etlservice.schedular.utils;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MQConfig {
    @Value("${queue.exchange}")
    private String QUEUE_EXCHANGE;
    @Value("${etl.routing.key}")
    private String ETL_ROUTING_KEY;
    @Value("${etl.queue}")
    private String etlQueue;

    @Bean
    public Queue etlQueue() {
        return new Queue(etlQueue);
    }

    @Bean
    @Primary
    public TopicExchange exchangeQueues() {
        return new TopicExchange(QUEUE_EXCHANGE);
    }

    @Bean
    @Primary
    public Binding bindingEtl(Queue etlQueue, TopicExchange exchangeQueues) {
        return BindingBuilder
                .bind(etlQueue)
                .to(exchangeQueues)
                .with(ETL_ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate (ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}