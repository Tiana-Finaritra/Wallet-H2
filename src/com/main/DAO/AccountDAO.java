package com.main.DAO;

import com.main.generic.GenericDAO;
import com.main.model.Account;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements GenericDAO<Account> {
    public static Connection connection;

    public AccountDAO(Connection connection){
        this.connection= connection;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        String sql = "Select * from Account";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                BigDecimal pay = resultSet.getBigDecimal("pay");
                String type = resultSet.getNString("type");


                Account account = new Account(id, name, pay, type);
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> saveAll(List<Account> toSave) {
        return null;
    }

    @Override
    public Account save(Account toSave) {
        return null;
    }

    @Override
    public Account delete(Account toDelete) {
        String sql = "Delete * from Account where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toDelete.getId());
            preparedStatement.executeUpdate();
            return toDelete;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
