package com.main.DAO;

import com.main.configurations.DatabaseConfiguration;
import com.main.generic.GenericDAO;
import com.main.model.AccountTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountTransactionDAO implements GenericDAO<AccountTransaction> {
    public static Connection connection;

    public AccountTransactionDAO(Connection connection) {
        this.connection = connection;
    }

    public AccountTransactionDAO() {

    }

    @Override
    public List<AccountTransaction> findAll() {
        List<AccountTransaction> accountTransactions = new ArrayList<>();

        String sql = "SELECT * FROM \"Account_transaction\"";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                AccountTransaction accountTransaction = new AccountTransaction();
                accountTransaction.setId(resultSet.getInt("id"));
                accountTransaction.setIdTransaction(resultSet.getInt("id_transaction"));
                accountTransaction.setIdAccount(resultSet.getInt("id_account"));

                accountTransactions.add(accountTransaction);
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return accountTransactions;
    }

    @Override
    public List<AccountTransaction> saveAll(List<AccountTransaction> toSave) {
        List<AccountTransaction> savedAccountTransactions = new ArrayList<>();

        String sql = "INSERT INTO \"Account_transaction\" (id, id_transaction, id_account)"
                + " VALUES (?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET id_transaction = EXCLUDED.id_transaction, id_account = EXCLUDED.id_account"
                + " RETURNING id";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            for (AccountTransaction accountTransaction : toSave) {
                preparedStatement.setInt(1, accountTransaction.getId());
                preparedStatement.setInt(2, accountTransaction.getIdTransaction());
                preparedStatement.setInt(3, accountTransaction.getIdAccount());

                ResultSet resultSet = preparedStatement.executeQuery();

                savedAccountTransactions.add(accountTransaction);
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return savedAccountTransactions;
    }

    @Override
    public AccountTransaction save(AccountTransaction toSave) {
        String sql = "INSERT INTO \"Account_transaction\" (id, id_transaction, id_account)"
                + " VALUES (?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET id_transaction = EXCLUDED.id_transaction, id_account = EXCLUDED.id_account"
                + " RETURNING id";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, toSave.getId());
            preparedStatement.setInt(2, toSave.getIdTransaction());
            preparedStatement.setInt(3, toSave.getIdAccount());

            ResultSet resultSet = preparedStatement.executeQuery();

            return toSave;

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }
        return null;
    }

    @Override
    public AccountTransaction delete(AccountTransaction toDelete) {
        String sql = "DELETE FROM \"Account_transaction\" WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.CallConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, toDelete.getId());

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("AccountTransaction with ID " + toDelete.getId() + " deleted successfully.");
                return toDelete;
            } else {
                System.out.println("AccountTransaction with ID " + toDelete.getId() + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return null;
    }
}
