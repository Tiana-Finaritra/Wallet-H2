package com.main.configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
    private static final String URL = System.getenv("url");
    private static final String USER = System.getenv("user");
    private static String PASSWORD = System.getenv("password");
    public static Connection CallConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}