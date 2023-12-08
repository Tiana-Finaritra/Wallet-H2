package com.main.services;

import com.main.model.Transaction;
import com.main.DAO.TransactionDAO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServices {

    public static Double getBalanceAtDateTime(int accountId, LocalDateTime dateTime) {
        List<Transaction> allTransactions = getAllTransactions(accountId);

        List<Transaction> filteredTransactions = allTransactions.stream()
                .filter(transaction -> transaction.getDateTime().isBefore(dateTime) || transaction.getDateTime().isEqual(dateTime))
                .collect(Collectors.toList());

        Double balance = calculateBalance(filteredTransactions);

        return balance;
    }

    private static List<Transaction> getAllTransactions(int accountId) {
        TransactionDAO transactionDAO = new TransactionDAO();
        List<Transaction> allTransactions = transactionDAO.findAll();

        return allTransactions.stream()
                .filter(transaction -> transaction.getIdAccount() == accountId)
                .collect(Collectors.toList());
    }

    private static Double calculateBalance(List<Transaction> transactions) {
        Double balance = 0.0;

        for (Transaction transaction : transactions) {
            if ("credit".equalsIgnoreCase(transaction.getType())) {
                balance += transaction.getAmount();
            } else if ("debit".equalsIgnoreCase(transaction.getType())) {
                balance -= transaction.getAmount();
            }
        }

        return balance;
    }
}
