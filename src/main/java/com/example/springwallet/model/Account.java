    package com.example.springwallet.model;

    import lombok.*;

    import java.util.Currency;
    import java.util.List;

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    public class Account {
        private String id;
        private String name;
        private double balance;
        private List<Transaction> transactions;
        private Currency currency;
        private AccountType type;
        public enum AccountType {
            BANK, CASH, MOBILE_MONEY
        }
    }
