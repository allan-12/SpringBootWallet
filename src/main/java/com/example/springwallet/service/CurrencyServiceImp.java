package com.example.springwallet.service;

import com.example.springwallet.model.Currency;
import com.example.springwallet.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImp implements CurrencyService{
    private final CurrencyRepository currencyRepository;
    public CurrencyServiceImp(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public void insertCurrency(Currency currency) {
        currencyRepository.insert(currency);
    }

    @Override
    public void updateCurrency(String id, Currency currency) {
        currencyRepository.update(id, currency);
    }

    @Override
    public void deleteCurrency(String id) {
        currencyRepository.delete(id);
    }

    @Override
    public Currency findCurrencyById(String id) {
        return currencyRepository.findById(id);
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }
}
