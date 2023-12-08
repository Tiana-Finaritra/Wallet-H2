package com.test;

import com.main.DAO.AccountTransactionDAO;
import com.main.model.AccountTransaction;

import java.util.ArrayList;
import java.util.List;

public class AccountTransactionDAOTest {
    public static void runAccountTransactionSaveTest() {
        System.out.println("\n============= save TEST ===========");
        AccountTransaction accountTransactionToSave = new AccountTransaction(1, 1, 1);
        AccountTransactionDAO accountTransactionDAO = new AccountTransactionDAO();
        AccountTransaction savedAccountTransaction = accountTransactionDAO.save(accountTransactionToSave);

        if (savedAccountTransaction != null) {
            System.out.println("==> AccountTransaction saved successfully with ID: " + savedAccountTransaction.getId());
        } else {
            System.out.println("==> Failed to save AccountTransaction.");
        }
        System.out.println("--");
    }

    public static void runAccountTransactionSaveAllTest() {
        System.out.println("\n============= saveAll TEST ===========");
        List<AccountTransaction> accountTransactionsToSave = new ArrayList<>();
        accountTransactionsToSave.add(new AccountTransaction(1, 1, 1));
        accountTransactionsToSave.add(new AccountTransaction(2, 2, 2));

        AccountTransactionDAO accountTransactionDAO = new AccountTransactionDAO();
        List<AccountTransaction> savedAccountTransactions = accountTransactionDAO.saveAll(accountTransactionsToSave);

        if (!savedAccountTransactions.isEmpty()) {
            System.out.println("==> AccountTransactions saved successfully:");
            for (AccountTransaction savedAccountTransaction : savedAccountTransactions) {
                System.out.println("\tID: " + savedAccountTransaction.getId());
            }
        } else {
            System.out.println("==> Failed to save AccountTransactions.");
        }
        System.out.println("--");
    }

    public static void runAccountTransactionFindAllTest() {
        System.out.println("\n============= findAll TEST ===========");
        AccountTransactionDAO accountTransactionDAO = new AccountTransactionDAO();
        List<AccountTransaction> accountTransactions = accountTransactionDAO.findAll();

        if (!accountTransactions.isEmpty()) {
            System.out.println("==> AccountTransactions found:");
            for (AccountTransaction accountTransaction : accountTransactions) {
                System.out.println("\tID: " + accountTransaction.getId() + ", ID Transaction: " + accountTransaction.getIdTransaction() + ", ID Account: " + accountTransaction.getIdAccount());
            }
        } else {
            System.out.println("==> No AccountTransactions found.");
        }
        System.out.println("--");
    }

    public static void runAccountTransactionDeleteTest() {
        System.out.println("\n============= delete TEST ===========");
        AccountTransactionDAO accountTransactionDAO = new AccountTransactionDAO();
        // Supposons que vous ayez une AccountTransaction existante à supprimer
        AccountTransaction accountTransactionToDelete = new AccountTransaction(1, 1, 1);

        AccountTransaction deletedAccountTransaction = accountTransactionDAO.delete(accountTransactionToDelete);

        if (deletedAccountTransaction != null) {
            System.out.println("==> AccountTransaction deleted successfully with ID: " + deletedAccountTransaction.getId());
        } else {
            System.out.println("==> Failed to delete AccountTransaction.");
        }
        System.out.println("--");
    }
}
