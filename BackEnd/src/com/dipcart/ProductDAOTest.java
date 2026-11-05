package com.dipcart;

import java.util.List;

import com.dipcart.dao.ProductDAO;
import com.dipcart.model.Product;

public class ProductDAOTest {

	public static void main(String[] args) {

	    ProductDAO dao = new ProductDAO();

	    boolean result = dao.deleteProduct(5);

	    if (result) {
	        System.out.println("Product deleted successfully!");
	    } else {
	        System.out.println("Product not found or deletion failed!");
	    }
	}
}