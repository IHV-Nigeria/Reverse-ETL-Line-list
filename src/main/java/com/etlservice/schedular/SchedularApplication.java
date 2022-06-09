package com.etlservice.schedular;

import com.etlservice.schedular.messaging.ETLConsumer;
import com.etlservice.schedular.serviceImpl.ARTLineListETLImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//@EnableAutoConfiguration
//@ComponentScan("com.etlservice.schedular")
@EnableRabbit
@SpringBootApplication
//@EnableScheduling
public class SchedularApplication {

    @Autowired
    ARTLineListETLImpl aRTLineListETLImpl;


    public static void main(String[] args) {
        SpringApplication.run(SchedularApplication.class, args);
    }

}
