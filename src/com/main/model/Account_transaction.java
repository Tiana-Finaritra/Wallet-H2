package com.main.model;

import java.util.Objects;

public class Account_transaction {
    private int id_account;
    private int id_transaction;

    public Account_transaction(int id_account, int id_transaction) {
        this.id_account = id_account;
        this.id_transaction = id_transaction;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public int getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(int id_transaction) {
        this.id_transaction = id_transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account_transaction that = (Account_transaction) o;
        return id_account == that.id_account && id_transaction == that.id_transaction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_account, id_transaction);
    }

    @Override
    public String toString() {
        return "Account_transaction{" +
                "id_account=" + id_account +
                ", id_transaction=" + id_transaction +
                '}';
    }
}
