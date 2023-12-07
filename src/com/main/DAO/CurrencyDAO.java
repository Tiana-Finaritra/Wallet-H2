package com.main.DAO;

import com.main.generic.GenericDAO;
import com.main.model.Account;
import com.main.model.Currency;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDAO implements GenericDAO<Currency> {
    public static Connection connection;

    public CurrencyDAO(Connection connection){
        this.connection= connection;
    }
    @Override
    public List<Currency> findAll() {
        List<Currency> currencies = new ArrayList<>();
        String sql = "Select * from Currency";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String code = resultSet.getNString("code");


                Currency currency = new Currency(id, name, code);
                currencies.add(currency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Currency> saveAll(List<Currency> toSave) {
        return null;
    }

    @Override
    public Currency save(Currency toSave) {
        return null;
    }

    @Override
    public Currency delete(Currency toDelete) {
        String query = "DELETE FROM currency WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, toDelete.getId());
            preparedStatement.executeUpdate();
            return toDelete;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
