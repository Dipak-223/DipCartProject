package com.dipcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:free";
        String username = "C##DIPCART";
        String password = "dipcart";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            System.out.println("Oracle Database Connected Successfully!");

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}