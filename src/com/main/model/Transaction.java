package com.main.model;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private String label;
    private Double amount;
    private LocalDateTime dateTime;
    private String type;
    private int idAccount;

    public Transaction(int id, String label, Double amount, LocalDateTime dateTime, String type, int idAccount) {
        this.id = id;
        this.label = label;
        this.amount = amount;
        this.dateTime = dateTime;
        this.type = type;
        this.idAccount = idAccount;
    }

    public Transaction() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", type='" + type + '\'' +
                ", idAccount=" + idAccount +
                '}';
    }
}
