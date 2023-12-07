package com.test;

import com.main.configurations.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;

public class DbConnectionTest {
    public static void connectionDBTest(){
        System.out.println("DATABASE CONNECTION TEST:");
        try (Connection connection = DatabaseConfiguration.CallConnection()){
            System.out.println("succes:" + "Connection réussite");
        } catch (SQLException e) {
            System.out.println("error:" + e.getMessage());
        }
    }
}
