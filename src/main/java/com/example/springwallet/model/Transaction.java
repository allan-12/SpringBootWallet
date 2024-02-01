package com.example.springwallet.model;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Transaction {
    private String id;
    private String label;
    private double amount;
    private LocalDateTime dateTime;
    private String account_id;
    private TransactionType type;

    public enum TransactionType {
        DEBIT, CREDIT
    }
}
