package com.example.springwallet.repository;

import com.example.springwallet.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository {
    void insert(Transaction transaction);

    void update(String id, Transaction transaction);

    void delete(String id);

    Transaction findById(String id);

    List<Transaction> findAll();
}
