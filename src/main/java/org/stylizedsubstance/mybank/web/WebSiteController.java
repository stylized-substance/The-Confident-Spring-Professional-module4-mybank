package org.stylizedsubstance.mybank.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.stylizedsubstance.mybank.model.Transaction;
import org.stylizedsubstance.mybank.service.TransactionService;
import org.stylizedsubstance.mybank.web.forms.CreateTransactionForm;

import java.util.List;
import java.util.Objects;

@Controller
public class WebSiteController {
    private final TransactionService transactionService;

    public WebSiteController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/account/{userId}")
    public String account(Model model, @PathVariable("userId") String userId) {
        List<Transaction> transactions = transactionService.findAll();
        // Find transactions for requested id
        List<Transaction> transactionsForUserId = transactions.stream()
                .filter(transaction -> Objects.equals(transaction.getUserId(), userId))
                .toList();

        model.addAttribute("transactions", transactionsForUserId);
        model.addAttribute("createTransactionForm", new CreateTransactionForm());

        return "account.html";
    }

    @PostMapping("/account/{userId}/createTransaction")
    public String createTransaction(@ModelAttribute CreateTransactionForm createTransactionForm, @PathVariable("userId") String userId) {
        String receivingUserId = createTransactionForm.getReceivingUserId();
        int amount = createTransactionForm.getAmount();
        String reference = createTransactionForm.getReference();
        transactionService.create(userId, receivingUserId, amount, reference);
        return "redirect:/account/" + userId;
    }
}
