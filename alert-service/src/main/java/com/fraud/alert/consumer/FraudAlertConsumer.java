package com.fraud.alert.consumer;

import com.fraud.common.dto.FraudAlertEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FraudAlertConsumer {

    @RabbitListener(queues = "fraud.queue")
    public void consume(FraudAlertEvent alert) {
        System.out.println("🚨 FRAUD ALERT RECEIVED 🚨");
        System.out.println("Transaction ID: " + alert.getTransactionId());
        System.out.println("Reason: " + alert.getReason());
    }
}
