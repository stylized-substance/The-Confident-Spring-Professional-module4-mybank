package org.stylizedsubstance.mybank.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.stylizedsubstance.mybank.model.Transaction;
import org.stylizedsubstance.mybank.util.DateTimeUtil;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TransactionService {
    private final DateTimeUtil dateTimeUtil;

    private final String bankSlogan;

    public TransactionService(DateTimeUtil dateTimeUtil, @Value("${bank.slogan}") String bankSlogan) {
        this.dateTimeUtil = dateTimeUtil;
        this.bankSlogan = bankSlogan;
    }

    List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public List<Transaction> findAll() {
        return transactions;
    }

    public Transaction create(String userId, String recipient, int amount, String reference) {
        Transaction transaction = new Transaction(userId, recipient, amount, reference, dateTimeUtil, bankSlogan);
        transactions.add(transaction);
        return transaction;
    }
}