package com.etlservice.schedular;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableAutoConfiguration
//@ComponentScan("com.etlservice.schedular")
@EnableRabbit
@SpringBootApplication
//@EnableScheduling
public class SchedularApplication {


    public static void main(String[] args) {
        SpringApplication.run(SchedularApplication.class, args);
    }

}
