package com.fraud.common.dto;

public class FraudAlertEvent {

    private String transactionId;
    private String userId;
    private String reason;

    public FraudAlertEvent() {}

    public FraudAlertEvent(String transactionId, String userId, String reason) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.reason = reason;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
