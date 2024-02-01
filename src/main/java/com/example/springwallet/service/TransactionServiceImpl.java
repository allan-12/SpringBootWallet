package com.example.springwallet.service;

import com.example.springwallet.model.Transaction;
import com.example.springwallet.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void insertTransaction(Transaction transaction) {
        transactionRepository.insert(transaction);
    }

    @Override
    public void updateTransaction(String id, Transaction transaction) {
        transactionRepository.update(id, transaction);
    }

    @Override
    public void deleteTransaction(String id) {
        transactionRepository.delete(id);
    }

    @Override
    public Transaction findTransactionById(String id) {
        return transactionRepository.findById(id);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
