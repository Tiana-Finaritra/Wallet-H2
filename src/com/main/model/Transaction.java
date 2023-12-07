package com.main.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Transaction {
    private int id;
    private  String label;
    private BigDecimal amount;
    private Date date_time;
    private String type;

    public Transaction(int id, String label, BigDecimal amount, Date date_time, String type) {
        this.id = id;
        this.label = label;
        this.amount = amount;
        this.date_time = date_time;
        this.type = type;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && Objects.equals(label, that.label) && Objects.equals(amount, that.amount) && Objects.equals(date_time, that.date_time) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, amount, date_time, type);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", amount=" + amount +
                ", date_time=" + date_time +
                ", type='" + type + '\'' +
                '}';
    }
}
