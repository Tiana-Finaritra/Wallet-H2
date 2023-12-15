package com.main.model;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor

public class TransactionCategory {
    private int id;
    private String name;
    private String itemsList;
}
