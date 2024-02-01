package com.example.springwallet.model;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BalanceHistory {
    private String account_id;
    private LocalDateTime dateTimeFrom;
    private LocalDateTime dateTimeTo;
    private double balance;
}
