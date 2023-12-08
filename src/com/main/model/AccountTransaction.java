package com.main.model;

public class AccountTransaction {
    private int id;
    private int idTransaction;
    private int idAccount;

    public AccountTransaction(int id, int idTransaction, int idAccount) {
        this.id = id;
        this.idTransaction = idTransaction;
        this.idAccount = idAccount;
    }

    public AccountTransaction() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "id=" + id +
                ", idTransaction=" + idTransaction +
                ", idAccount=" + idAccount +
                '}';
    }
}
