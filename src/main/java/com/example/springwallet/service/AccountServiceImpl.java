package com.example.springwallet.service;

import com.example.springwallet.model.Account;
import com.example.springwallet.model.Transaction;
import com.example.springwallet.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void insertAccount(Account account) {
        accountRepository.insert(account);
    }

    @Override
    public void updateAccount(String id, Account account) {
        accountRepository.update(id, account);
    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.delete(id);
    }

    @Override
    public Account findAccountById(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
