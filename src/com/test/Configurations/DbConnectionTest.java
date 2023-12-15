package com.test.Configurations;

import com.main.configurations.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;

public class DbConnectionTest {
    public static void connectionDBTest() {
        System.out.println("\n=====DATABASE CONNECTION TEST=====");
        try (Connection connection = DatabaseConfiguration.CallConnection()) {
            System.out.println("==> succes:" + " Connection réussite");
        } catch (SQLException e) {
            System.out.println("==> error: " + e.getMessage());
        }
        System.out.println("-------------------------------");
    }
}