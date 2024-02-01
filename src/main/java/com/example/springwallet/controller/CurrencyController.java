package com.example.springwallet.controller;

import com.example.springwallet.model.Currency;
import com.example.springwallet.service.CurrencyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/all")
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @PostMapping("/insertCurrency")
    public void insertCurrency(@RequestBody Currency currency) {
        currencyService.insertCurrency(currency);
    }

    @PutMapping("/updateCurrency/{id}")
    public void updateCurrency(@RequestBody Currency currency, @PathVariable String id) {
        currencyService.updateCurrency(id, currency);
    }

    @DeleteMapping("/deleteCurrency/{id}")
    public void deleteCurrency(@PathVariable String id) {
        currencyService.deleteCurrency(id);
    }

    @GetMapping("/getCurrency/{id}")
    public Currency findCurrencyById(@PathVariable String id) {
        return currencyService.findCurrencyById(id);
    }
}
