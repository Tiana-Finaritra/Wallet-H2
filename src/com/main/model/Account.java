package com.main.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private int id;
    private String name;
    private BigDecimal pay;
    private String type;

    public Account(int id, String name, BigDecimal pay, String type) {
        this.id = id;
        this.name = name;
        this.pay = pay;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
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
        Account account = (Account) o;
        return id == account.id && Objects.equals(name, account.name) && Objects.equals(pay, account.pay) && Objects.equals(type, account.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pay, type);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pay=" + pay +
                ", type='" + type + '\'' +
                '}';
    }
}
