package com.example.springwallet.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Currency {
    private String id;
    private Name name;
    private Code code;

    public enum Name {
        EURO, ARIARY, DOLLAR
    }

    public enum Code {
        EUR, AR, USD
    }
}
