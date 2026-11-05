package com.dipcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionTest {

	public static void main(String[] args) {

	    String url = "jdbc:oracle:thin:@localhost:1521:free";
	    String username = "C##DIPCART";
	    String password = "dipcart";

	    String query = "DELETE FROM PRODUCTS WHERE PRODUCT_ID = ?";

	    try {

	        Connection con = DriverManager.getConnection(url, username, password);

	        PreparedStatement ps = con.prepareStatement(query);

	        ps.setInt(1, 5);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Product deleted successfully!");
	        } else {
	            System.out.println("Product not found!");
	        }

	        ps.close();
	        con.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}