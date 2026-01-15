package com.fraud.ruleengine.service;

import com.fraud.common.dto.TransactionEvent;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FraudRuleService {

    public boolean isFraud(TransactionEvent event) {

        // Rule 1: High amount
        if (event.getAmount().compareTo(new BigDecimal("10000")) > 0) {
            return true;
        }

        // Rule 2: Suspicious location
        if ("INTERNATIONAL".equalsIgnoreCase(event.getLocation())) {
            return true;
        }

        return false;
    }
}
