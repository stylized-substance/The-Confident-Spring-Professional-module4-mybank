package org.stylizedsubstance.mybank.model;

import org.stylizedsubstance.mybank.util.DateTimeUtil;

import java.util.UUID;

public class Transaction {
    private String transactionId;
    private String userId;
    private String recipient;
    private int amount; // Monetary amount in cents
    private String timestamp;
    private String reference;
    private String bankSlogan;

    public Transaction(String userId, String recipient, int amount, String reference, DateTimeUtil dateTimeUtil, String bankSlogan) {
        this.transactionId = UUID.randomUUID().toString();
        this.userId = userId;
        this.recipient = recipient;
        this.amount = amount;
        this.reference = reference;
        this.timestamp = dateTimeUtil.createTimeStamp();
        this.bankSlogan = bankSlogan;
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

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getBankSlogan() {
        return bankSlogan;
    }

    public void setBankSlogan(String bankSlogan) {
        this.bankSlogan = bankSlogan;
    }
}
