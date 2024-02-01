package com.example.springwallet.service;

import com.example.springwallet.model.Currency;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CurrencyService {
    void insertCurrency(Currency currency);

    void updateCurrency(String id, Currency currency);

    void deleteCurrency(String id);

    Currency findCurrencyById(String id);

    List<Currency> getAllCurrencies();
}
