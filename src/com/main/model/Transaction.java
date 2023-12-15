package com.main.model;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Transaction {
    private int id;
    private String label;
    private Double amount;
    private LocalDateTime dateTime;
    private String type;
    private int idAccount;
    private int idCategory;

    public Transaction(int i, String purchase, double v, LocalDateTime now, String debit, int i1) {
    }
}
