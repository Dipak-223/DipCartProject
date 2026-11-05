package com.dipcart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:free";

    private static final String USERNAME = "C##DIPCART";

    private static final String PASSWORD = "dipcart";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Oracle JDBC Driver not found!", e);
        }

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
