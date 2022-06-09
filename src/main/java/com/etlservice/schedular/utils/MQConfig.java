package com.etlservice.schedular.utils;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MQConfig {
    public static final String QUEUE_EXCHANGE = "queue_exchange";
    public static final String CONSUMER_ROUTING_KEY = "consumer_routing_key";;
    public static final String VALIDATOR_ROUTING_KEY = "validator_routing_key";
    public static final String ETL_ROUTING_KEY = "number-1";

    @Bean
    public Queue queueConsumer() {
        return new Queue(QueueNames.CONSUMER_QUEUE);
    }

    @Bean
    public Queue queueValidator() {
        return new Queue(QueueNames.VALIDATOR_QUEUE);
    }

    @Bean
    public Queue etlQueue() {
        return new Queue(QueueNames.ETL_QUEUE);
    }

    @Bean
    @Primary
    public TopicExchange exchangeQueues() {
        return new TopicExchange(QUEUE_EXCHANGE);
    }

    @Bean
    @Primary
    public Binding bindingConsumer(Queue queueConsumer, TopicExchange exchangeQueues){
        return BindingBuilder
                .bind(queueConsumer)
                .to(exchangeQueues)
                .with(CONSUMER_ROUTING_KEY);
    }

    @Bean
    @Primary
    public Binding bindingStudentBulk(Queue queueValidator, TopicExchange exchangeQueues){
        return BindingBuilder
                .bind(queueValidator)
                .to(exchangeQueues)
                .with(VALIDATOR_ROUTING_KEY);
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