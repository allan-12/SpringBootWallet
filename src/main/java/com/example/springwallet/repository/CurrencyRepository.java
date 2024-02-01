package com.example.springwallet.repository;

import com.example.springwallet.model.Currency;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CurrencyRepository {
    void insert(Currency currency);

    void update(String id, Currency currency);

    void delete(String id);

    Currency findById(String id);

    List<Currency> findAll();
}
