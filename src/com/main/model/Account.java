package com.main.model;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor

public class Account {
    private int id;
    private String name;
    private Double pay;
    private LocalDateTime lastUpdateDateTime;
    private int idCurrency;
    private String type;
    private Double balance;

    public Account(int i, String johnDoe, double v, int i1, String banque) {
    }
}
