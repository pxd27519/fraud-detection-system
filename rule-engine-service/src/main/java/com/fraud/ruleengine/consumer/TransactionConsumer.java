package com.fraud.ruleengine.consumer;

import com.fraud.common.dto.TransactionEvent;
import com.fraud.common.dto.FraudAlertEvent;

import com.fraud.ruleengine.service.FraudAlertProducer;
import com.fraud.ruleengine.service.FraudRuleService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {

    private final FraudRuleService fraudRuleService;
    private final FraudAlertProducer alertProducer;

    public TransactionConsumer(FraudRuleService fraudRuleService,
                               FraudAlertProducer alertProducer) {
        this.fraudRuleService = fraudRuleService;
        this.alertProducer = alertProducer;
    }

    @KafkaListener(topics = "transaction-topic", groupId = "fraud-rule-engine")
    public void consume(TransactionEvent event) {

        System.out.println("Received transaction: " + event.getTransactionId());

        boolean fraud = fraudRuleService.isFraud(event);

        if (fraud) {
            System.out.println("FRAUD DETECTED: " + event.getTransactionId());

            FraudAlertEvent alertEvent =
                    new FraudAlertEvent(
                            event.getTransactionId(),
                            event.getUserId(),
                            "High risk transaction detected"
                    );

            alertProducer.sendFraudAlert(alertEvent);
        }
    }
}
