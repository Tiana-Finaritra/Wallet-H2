package com.main.DAO;

import com.main.configurations.DatabaseConfiguration;
import com.main.generic.GenericDAO;
import com.main.model.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDAO implements GenericDAO<Currency> {
    public static Connection connection;

    public CurrencyDAO(Connection connection) {
        this.connection = connection;
    }

    public CurrencyDAO() {

    }

    @Override
    public List<Currency> findAll() {
        List<Currency> currencies = new ArrayList<>();

        String sql = "SELECT * FROM \"Currency\"";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Currency currency = new Currency();
                currency.setId(resultSet.getInt("id"));
                currency.setName(resultSet.getString("name"));
                currency.setCode(resultSet.getString("code"));

                currencies.add(currency);
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return currencies;
    }

    @Override
    public List<Currency> saveAll(List<Currency> toSave) {
        List<Currency> savedCurrencies = new ArrayList<>();

        String sql = "INSERT INTO \"Currency\" (id, name, code)"
                + " VALUES (?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET name = EXCLUDED.name, code = EXCLUDED.code"
                + " RETURNING id";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            for (Currency currency : toSave) {
                preparedStatement.setInt(1, currency.getId());
                preparedStatement.setString(2, currency.getName());
                preparedStatement.setString(3, currency.getCode());

                ResultSet resultSet = preparedStatement.executeQuery();

                savedCurrencies.add(currency);
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return savedCurrencies;
    }

    @Override
    public Currency save(Currency toSave) {
        String sql = "INSERT INTO \"Currency\" (id, name, code)"
                + " VALUES (?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET name = EXCLUDED.name, code = EXCLUDED.code"
                + " RETURNING id";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, toSave.getId());
            preparedStatement.setString(2, toSave.getName());
            preparedStatement.setString(3, toSave.getCode());

            ResultSet resultSet = preparedStatement.executeQuery();

            return toSave;

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Currency delete(Currency toDelete) {
        String sql = "DELETE FROM \"Currency\" WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, toDelete.getId());

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Currency with ID " + toDelete.getId() + " deleted successfully.");
                return toDelete;
            } else {
                System.out.println("Currency with ID " + toDelete.getId() + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return null;
    }
}
