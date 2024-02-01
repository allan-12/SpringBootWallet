package com.example.springwallet.controller;

import com.example.springwallet.model.Account;
import com.example.springwallet.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/insertAccount")
    public void insertAccount(@RequestBody Account account) {
        accountService.insertAccount(account);
    }

    @PutMapping("/updateAccount/{id}")
    public void updateAccount(@RequestBody Account account, @PathVariable String id) {
        accountService.updateAccount(id, account);
    }

    @DeleteMapping("/deleteAccount/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
    }

    @GetMapping("/getAccount/{id}")
    public Account findAccountById(@PathVariable String id) {
        return accountService.findAccountById(id);
    }
}

