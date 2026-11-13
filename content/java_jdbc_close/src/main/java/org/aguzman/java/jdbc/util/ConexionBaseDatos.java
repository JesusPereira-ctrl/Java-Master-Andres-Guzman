package org.aguzman.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static final String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Santiago";
    private static final String username = "root";
    private static final String password = "5696";

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
