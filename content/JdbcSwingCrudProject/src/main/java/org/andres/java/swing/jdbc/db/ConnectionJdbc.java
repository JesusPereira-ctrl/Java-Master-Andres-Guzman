package org.andres.java.swing.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJdbc {

    private final static String URL = "jdbc:mysql://localhost:3306/swing_products";
    private final static String USER = "root";
    private final static String PASSWORD = "5696";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
