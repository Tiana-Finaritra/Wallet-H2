package com.test;

import com.main.DAO.TransactionDAO;
import com.main.model.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOTest {
    public static void runTransactionSaveTest() {
        System.out.println("\n============= save TEST ===========");
        Transaction transactionToSave = new Transaction(1, "Purchase", 50.0, LocalDateTime.now(), "debit", 1);
        TransactionDAO transactionDao = new TransactionDAO();
        Transaction savedTransaction = transactionDao.save(transactionToSave);

        if (savedTransaction != null) {
            System.out.println("==> Transaction saved successfully with ID: " + savedTransaction.getId());
        } else {
            System.out.println("==> Failed to save transaction.");
        }
        System.out.println("--");
    }

    public static void runTransactionSaveAllTest() {
        System.out.println("\n============= saveAll TEST ===========");
        List<Transaction> transactionsToSave = new ArrayList<>();
        transactionsToSave.add(new Transaction(1, "Purchase", 50.0, LocalDateTime.now(), "debit", 1));
        transactionsToSave.add(new Transaction(2, "Salary", 1000.0, LocalDateTime.now(), "credit", 2));

        TransactionDAO transactionDao = new TransactionDAO();
        List<Transaction> savedTransactions = transactionDao.saveAll(transactionsToSave);

        if (!savedTransactions.isEmpty()) {
            System.out.println("==> Transactions saved successfully:");
            for (Transaction savedTransaction : savedTransactions) {
                System.out.println("\tID: " + savedTransaction.getId());
            }
        } else {
            System.out.println("==> Failed to save transactions.");
        }
        System.out.println("--");
    }

    public static void runTransactionFindAllTest() {
        System.out.println("\n============= findAll TEST ===========");
        TransactionDAO transactionDao = new TransactionDAO();
        List<Transaction> transactions = transactionDao.findAll();

        if (!transactions.isEmpty()) {
            System.out.println("==> Transactions found:");
            for (Transaction transaction : transactions) {
                System.out.println("\tID: " + transaction.getId() + ", Label: " + transaction.getLabel() + ", Amount: " + transaction.getAmount());
            }
        } else {
            System.out.println("==> No transactions found.");
        }
        System.out.println("--");
    }

    public static void runTransactionDeleteTest() {
        System.out.println("\n============= delete TEST ===========");
        TransactionDAO transactionDao = new TransactionDAO();
        // Supposons que vous ayez une transaction existante à supprimer
        Transaction transactionToDelete = new Transaction(1, "Purchase", 50.0, LocalDateTime.now(), "debit", 1);

        Transaction deletedTransaction = transactionDao.delete(transactionToDelete);

        if (deletedTransaction != null) {
            System.out.println("==> Transaction deleted successfully with ID: " + deletedTransaction.getId());
        } else {
            System.out.println("==> Failed to delete transaction.");
        }
        System.out.println("--");
    }
}
