package com.fraud.ruleengine.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FRAUD_QUEUE = "fraud.alert.queue";

    @Bean
    public Queue fraudQueue() {
        return new Queue(FRAUD_QUEUE, true);
    }
}
