package com.example.springwallet.service;

import com.example.springwallet.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {
    void insertAccount(Account account);

    void updateAccount(String id, Account account);

    void deleteAccount(String id);

    Account findAccountById(String id);

    List<Account> getAllAccounts();
}
