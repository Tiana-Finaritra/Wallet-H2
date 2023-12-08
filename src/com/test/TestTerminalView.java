package com.test;

public class TestTerminalView {
    public  static void AllDAOTestAccount () {
        System.out.println("\n++++++++ACCOUNT:");
        DbConnectionTest.connectionDBTest();
        AccountDAOTest.runAccountSaveTest();
        AccountDAOTest.runAccountSaveAllTest();
        AccountDAOTest.runAccountFindAllTest();
        AccountDAOTest.runAccountDeleteTest();
    }
}
