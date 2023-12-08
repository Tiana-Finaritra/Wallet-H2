package com.main.services;

import com.main.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AccountServices {
    public Account effectuerTransaction(Account account, String label, double montant, String typeTransaction) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection =

                    connection;

            String insertTransactionQuery = "INSERT INTO transactions (compte_id, label, montant, date_heure, type_transaction) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertTransactionQuery);
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, label);
            preparedStatement.setDouble(3, montant);
            preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setString(5, typeTransaction);
            preparedStatement.executeUpdate();

            if (account.getType().equals("Banque") || (account.getType() != "Banque" && account.getPay() >= montant)) {
                if (typeTransaction.equals("Débit")) {
                    account.setPay(account.getPay() - montant);
                } else if (typeTransaction.equals("Crédit")) {
                    account.setPay(account.getPay() + montant);
                }

             String updateSoldeQuery = "UPDATE account\"Account\" SET pay = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(updateSoldeQuery);
                preparedStatement.setDouble(1, account.getPay());
                preparedStatement.setInt(2, account.getId());
                preparedStatement.executeUpdate();

                connection.commit();
            } else {
                connection.rollback();
                throw new RuntimeException("Solde insuffisant pour effectuer la transaction.");
            }

        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return account;
    }
}
