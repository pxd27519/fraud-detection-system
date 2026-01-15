package com.fraud.ruleengine.service;

import com.fraud.ruleengine.config.RabbitMQConfig;
import com.fraud.common.dto.TransactionEvent;
import com.fraud.common.dto.FraudAlertEvent;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class FraudAlertProducer {

    private final RabbitTemplate rabbitTemplate;

    public FraudAlertProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendFraudAlert(FraudAlertEvent event) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.FRAUD_QUEUE,
                event
        );
    }
}
