package com.main.DAO;

import com.main.configurations.DatabaseConfiguration;
import com.main.generic.GenericDAO;
import com.main.model.Account;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements GenericDAO<Account> {
    public static Connection connection;

    public AccountDAO(Connection connection) {
        this.connection = connection;
    }

    public AccountDAO() {

    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM Account";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double pay = resultSet.getDouble("pay");
                int idCurrency = resultSet.getInt("idCurrency");
                LocalDateTime lastUpdate = resultSet.getTimestamp("last_update_date_time").toLocalDateTime();
                String type = resultSet.getString("type");

                Account account = new Account(id, name, pay, lastUpdate, idCurrency, type);
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public List<Account> saveAll(List<Account> toSave) {
        return null;
    }

    @Override
    public Account save(Account toSave) {
        String sql = "INSERT INTO \"Account\" (id, name, pay, id_currency, type)"
                + " VALUES (?,?,?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET name = EXCLUDED.name, pay = EXCLUDED.pay, id_currency = EXCLUDED.id_currency, type = EXCLUDED.type"
                + " RETURNING id";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toSave.getId());
            preparedStatement.setString(2, toSave.getName());
            preparedStatement.setDouble(3, toSave.getPay());
            preparedStatement.setInt(4, toSave.getIdCurrency());
            preparedStatement.setString(5, toSave.getType());

            ResultSet resultSet = preparedStatement.executeQuery();

            return toSave;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
