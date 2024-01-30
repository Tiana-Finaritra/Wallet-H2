package com.main.configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
    // private static final String URL = System.getenv("url");
    // private static final String USER = System.getenv("user");
    // private static String PASSWORD = System.getenv("password");

    private static final String URL = "jdbc:postgresql://localhost:5432/wallet2";
    private static final String USER = "postgres";
    private static String PASSWORD = "12345678";

    public static Connection CallConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}