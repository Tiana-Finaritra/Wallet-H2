package com.test;

import com.main.DAO.AccountDAO;
import com.main.model.Account;
import com.main.services.AccountServices;


import java.util.ArrayList;
import java.util.List;

public class AccountDAOTest {
    public static void runAccountSaveTest() {
        System.out.println("\n============= save TEST ===========");
        Account accountToSave = new Account(1, "John Doe", 1000.0, 1, "Banque");
        AccountDAO accountDao = new AccountDAO();
        Account savedAccount = accountDao.save(accountToSave);

        if (savedAccount != null) {
            System.out.println("==> Account saved successfully with ID: " + savedAccount.getId());
        } else {
            System.out.println("==> Failed to save account.");
        }
        System.out.println("--");
    }

    public static void runAccountSaveAllTest() {
        System.out.println("\n============= saveAll TEST ===========");
        List<Account> accountsToSave = new ArrayList<>();
        accountsToSave.add(new Account(1, "John Doe", 1000.0, 1, "Banque"));
        accountsToSave.add(new Account(2, "Jane Doe", 2000.0, 2, "Mobile Money"));

        AccountDAO accountDao = new AccountDAO();
        List<Account> savedAccounts = accountDao.saveAll(accountsToSave);

        if (!savedAccounts.isEmpty()) {
            System.out.println("==> Accounts saved successfully:");
            for (Account savedAccount : savedAccounts) {
                System.out.println("\tID: " + savedAccount.getId());
            }
        } else {
            System.out.println("==> Failed to save accounts.");
        }
        System.out.println("--");
    }

    public static void runAccountFindAllTest() {
        System.out.println("\n============= findAll TEST ===========");
        AccountDAO accountDao = new AccountDAO();
        List<Account> accounts = accountDao.findAll();

        if (!accounts.isEmpty()) {
            System.out.println("==> Accounts found:");
            for (Account account : accounts) {
                System.out.println("\tID: " + account.getId() + ", Name: " + account.getName() + ", Pay: " + account.getPay());
            }
        } else {
            System.out.println("==> No accounts found.");
        }
        System.out.println("--");
    }

    public static void runAccountDeleteTest() {
        System.out.println("\n============= delete TEST ===========");
        AccountDAO accountDao = new AccountDAO();
        // RADO, En supposant que vous ayez un compte existant à supprimer
        Account accountToDelete = new Account(1, "John Doe", 1000.0, 1, "Banque");

        Account deletedAccount = accountDao.delete(accountToDelete);

        if (deletedAccount != null) {
            System.out.println("==> Account deleted successfully with ID: " + deletedAccount.getId());
        } else {
            System.out.println("==> Failed to delete account.");
        }
        System.out.println("--");
    }

        public static void main(String[] args) {
            AccountServices accountServices = new AccountServices();

            Account account = new Account();

            System.out.println("Solde initial : " + account.getPay());

            account = accountServices.effectuerTransaction(account, "Dépôt", 100.0, "Crédit");
            System.out.println("Solde après dépôt : " + account.getPay());

            account = accountServices.effectuerTransaction(account, "Retrait", 50.0, "Débit");
            System.out.println("Solde après retrait : " + account.getPay());

            try {
                account = accountServices.effectuerTransaction(account, "Achat", 60.0, "Débit");
            } catch (RuntimeException e) {
                System.out.println("Transaction échouée : " + e.getMessage());
            }

            System.out.println("Solde final : " + account.getPay());
        }
    }

