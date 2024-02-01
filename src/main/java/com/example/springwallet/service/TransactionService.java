package com.example.springwallet.service;

import com.example.springwallet.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TransactionService {
    void insertTransaction(Transaction transaction);

    void updateTransaction(String id, Transaction transaction);

    void deleteTransaction(String id);

    Transaction findTransactionById(String id);

    List<Transaction> getAllTransactions();
}
