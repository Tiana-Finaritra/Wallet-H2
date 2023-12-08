package com.test;

public class TestTerminalView {
    public static void AllDAOTestAccount() {
        System.out.println("\n++++++++ACCOUNT:");
        DbConnectionTest.connectionDBTest();
        AccountDAOTest.runAccountSaveTest();
        AccountDAOTest.runAccountSaveAllTest();
        AccountDAOTest.runAccountFindAllTest();
        AccountDAOTest.runAccountDeleteTest();
    }

    public static void AllDAOTestCurrency() {
        System.out.println("\n++++++++CURRENCY:");
        DbConnectionTest.connectionDBTest();
        CurrencyDAOTest.runCurrencySaveTest();
        CurrencyDAOTest.runCurrencySaveAllTest();
        CurrencyDAOTest.runCurrencyFindAllTest();
        CurrencyDAOTest.runCurrencyDeleteTest();
    }
    public static void AllDAOTestTransaction() {
        System.out.println("\n++++++++TRANSACTION:");
        DbConnectionTest.connectionDBTest();
        TransactionDAOTest.runTransactionSaveTest();
        TransactionDAOTest.runTransactionSaveAllTest();
        TransactionDAOTest.runTransactionFindAllTest();
        TransactionDAOTest.runTransactionDeleteTest();
    }
}
