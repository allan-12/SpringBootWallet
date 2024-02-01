package com.example.springwallet.model;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TransferHistory {
    private String debitorTransactionId;
    private String creditorTransactionId;
    private double transferAmount;
    private LocalDateTime transferDate;
}
