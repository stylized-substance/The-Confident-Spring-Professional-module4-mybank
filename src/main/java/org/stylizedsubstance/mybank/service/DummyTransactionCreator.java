package org.stylizedsubstance.mybank.service;

// Class creates dummy transactions for development

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DummyTransactionCreator {
    private final TransactionService transactionService;

    public DummyTransactionCreator(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostConstruct
    public void setup() {
        System.out.println("Creating dev transactions");
        int amount = 100;
        int multiplier = 2;
        for (int i = 0; i < 5; i++) {
            transactionService.create("User0", amount, "devTransaction" + i);
            transactionService.create("User1", amount, "devTransaction" + i);
            amount *= multiplier;
        }
    }
}
