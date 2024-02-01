package com.example.springwallet.repository;

import com.example.springwallet.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepository {
    void insert(Account account);

    void update(String id, Account account);

    void delete(String id);

    Account findById(String id);

    List<Account> findAll();
}
