package com.example.springwallet.model;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CurrencyValue {
    private int id;
    private int idCurrencySource;
    private int idCurrencyDestination;
    private double value;
    private LocalDate dateValue;
}
