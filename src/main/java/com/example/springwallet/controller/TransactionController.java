package com.example.springwallet.controller;

import com.example.springwallet.model.Transaction;
import com.example.springwallet.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping("/insertTransaction")
    public void insertTransaction(@RequestBody Transaction transaction) {
        transactionService.insertTransaction(transaction);
    }

    @PutMapping("/updateTransaction/{id}")
    public void updateTransaction(@RequestBody Transaction transaction, @PathVariable String id) {
        transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/deleteTransaction/{id}")
    public void deleteTransaction(@PathVariable String id) {
        transactionService.deleteTransaction(id);
    }

    @GetMapping("/getTransaction/{id}")
    public Transaction findTransactionById(@PathVariable String id) {
        return transactionService.findTransactionById(id);
    }
}
