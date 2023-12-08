package com.main.DAO;

import com.main.configurations.DatabaseConfiguration;
import com.main.generic.GenericDAO;
import com.main.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        String sql = "SELECT * FROM \"Account\"";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setPay(resultSet.getDouble("pay"));
                account.setIdCurrency(resultSet.getInt("id_currency"));
                account.setType(resultSet.getString("type"));

                accounts.add(account);
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return accounts;
    }


    @Override
    public List<Account> saveAll(List<Account> toSave) {
        List<Account> savedAccounts = new ArrayList<>();

        String sql = "INSERT INTO \"Account\" (id, name, pay, id_currency, type)"
                + " VALUES (?,?,?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET name = EXCLUDED.name, pay = EXCLUDED.pay, id_currency = EXCLUDED.id_currency, type = EXCLUDED.type"
                + " RETURNING id";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            for (Account account : toSave) {
                preparedStatement.setInt(1, account.getId());
                preparedStatement.setString(2, account.getName());
                preparedStatement.setDouble(3, account.getPay());
                preparedStatement.setInt(4, account.getIdCurrency());
                preparedStatement.setString(5, account.getType());

                ResultSet resultSet = preparedStatement.executeQuery();

                savedAccounts.add(account);
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return savedAccounts;
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
            System.out.println("==> erreur: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Account delete(Account toDelete) {
        String sql = "DELETE FROM \"Account\" WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, toDelete.getId());

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Account with ID " + toDelete.getId() + " deleted successfully.");
                return toDelete;
            } else {
                System.out.println("Account with ID " + toDelete.getId() + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return null;
    }
}