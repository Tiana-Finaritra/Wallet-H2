package com.main.DAO;

import com.main.configurations.DatabaseConfiguration;
import com.main.generic.GenericDAO;
import com.main.model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO implements GenericDAO<Transaction> {
    public static Connection connection;

    public TransactionDAO(Connection connection) {
        this.connection = connection;
    }

    public TransactionDAO() {

    }

    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactions = new ArrayList<>();

        String sql = "SELECT * FROM \"Transaction\"";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));
                transaction.setLabel(resultSet.getString("label"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setDateTime(resultSet.getTimestamp("date_time").toLocalDateTime());
                transaction.setType(resultSet.getString("type"));
                transaction.setIdAccount(resultSet.getInt("id_account"));

                transactions.add(transaction);
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return transactions;
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> toSave) {
        List<Transaction> savedTransactions = new ArrayList<>();

        String sql = "INSERT INTO \"Transaction\" (id, label, amount, date_time, type, id_account)"
                + " VALUES (?,?,?,?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET label = EXCLUDED.label, amount = EXCLUDED.amount, date_time = EXCLUDED.date_time, type = EXCLUDED.type, id_account = EXCLUDED.id_account"
                + " RETURNING id";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            for (Transaction transaction : toSave) {
                preparedStatement.setInt(1, transaction.getId());
                preparedStatement.setString(2, transaction.getLabel());
                preparedStatement.setDouble(3, transaction.getAmount());
                preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(transaction.getDateTime()));
                preparedStatement.setString(5, transaction.getType());
                preparedStatement.setInt(6, transaction.getIdAccount());

                ResultSet resultSet = preparedStatement.executeQuery();

                savedTransactions.add(transaction);
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return savedTransactions;
    }

    @Override
    public Transaction save(Transaction toSave) {
        String sql = "INSERT INTO \"Transaction\" (id, label, amount, date_time, type, id_account)"
                + " VALUES (?,?,?,?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET label = EXCLUDED.label, amount = EXCLUDED.amount, date_time = EXCLUDED.date_time, type = EXCLUDED.type, id_account = EXCLUDED.id_account"
                + " RETURNING id";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, toSave.getId());
            preparedStatement.setString(2, toSave.getLabel());
            preparedStatement.setDouble(3, toSave.getAmount());
            preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(toSave.getDateTime()));
            preparedStatement.setString(5, toSave.getType());
            preparedStatement.setInt(6, toSave.getIdAccount());

            ResultSet resultSet = preparedStatement.executeQuery();

            return toSave;

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Transaction delete(Transaction toDelete) {
        String sql = "DELETE FROM \"Transaction\" WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, toDelete.getId());

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Transaction with ID " + toDelete.getId() + " deleted successfully.");
                return toDelete;
            } else {
                System.out.println("Transaction with ID " + toDelete.getId() + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return null;
    }
}
