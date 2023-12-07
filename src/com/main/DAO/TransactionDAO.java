package com.main.DAO;

import com.main.generic.GenericDAO;
import com.main.model.Transaction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDAO implements GenericDAO<Transaction> {
    public static Connection connection;

    public TransactionDAO(Connection connection){
        this.connection= connection;
    }
    @Override
    public List<Transaction> findAll() {
        List<Transaction> accounts = new ArrayList<>();
        String sql = "Select * from Transaction";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String label = resultSet.getString("label");
                BigDecimal amount = resultSet.getBigDecimal("amount");
                Date date_time = resultSet.getDate("date_time");
                String  type = resultSet.getNString("type");

                Transaction account = new Transaction(id, label, amount, date_time, type);
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> toSave) {
        return null;
    }

    @Override
    public Transaction save(Transaction toSave) {
        return null;
    }

    @Override
    public Transaction delete(Transaction toDelete) {
        String sql = "DELETE FROM transaction WHERE id = ?";
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
