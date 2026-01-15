package com.fraud.transaction.controller;

import com.fraud.common.dto.TransactionEvent;
import com.fraud.transaction.service.TransactionProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionProducer producer;

    public TransactionController(TransactionProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<String> createTransaction(@RequestBody TransactionEvent request) {
        producer.sendTransaction(request);
        return ResponseEntity.ok("Transaction sent for fraud analysis");
    }
}
