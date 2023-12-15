package com.main.model;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString

public class AccountTransaction {
    private int id;
    private int idTransaction;
    private int idAccount;
}
