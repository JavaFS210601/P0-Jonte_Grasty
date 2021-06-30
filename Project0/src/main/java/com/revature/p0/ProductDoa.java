package com.revature.p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductDoa implements ProductDoaInterface {
	
	final Logger log = LogManager.getLogger(Menu.class);

	@Override
	public List<Product> listProducts() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			ResultSet rs = null;
			String sql = "SELECT * FROM products;";
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);

			List<Product> productList = new ArrayList<>();

			while (rs.next()) {

				Product product = new Product(rs.getInt("product_number"), rs.getString("product_name"),
						rs.getString("product_description"), rs.getString("product_category"), rs.getInt("ctr_number"));

				productList.add(product);

			} // end while

			log.info("End-user viewed product list");
			return productList;

		} catch (SQLException e) { // if something goes wrong accessing our data, it will get caught
			System.out.println("Something went wrong when trying to access your DB");
			e.printStackTrace();
		}

		return null;
	}// end listProducts()

	@Override
	public void addProduct(Product product) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO products (product_number, product_name, product_description, product_category, ctr_number)"
					+ "VALUES (?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, product.getProduct_number());
			ps.setString(2, product.getProduct_name());
			ps.setString(3, product.getProduct_description());
			ps.setString(4, product.getProduct_category());
			ps.setInt(5, product.getCtr_number());

			ps.executeUpdate();

			System.out.println("New product: " + product.getProduct_name() + " added!");
			log.info("End-user added product");

		} catch (SQLException e) {
			System.out.println("New product not added.");
			e.printStackTrace();
		} // end try-catch

	}// end addProduct

	@Override
	public void removeProduct(int product_number) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "DELETE FROM products WHERE product_number = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, product_number);
//		
			ps.executeUpdate();

			System.out.println("Product: " + product_number + " removed!");
			log.info("End-user removed product");

		} catch (SQLException e) {
			System.out.println("Product not deleted!");
			e.printStackTrace();

		} // end try-catch
	}// end removeProduct

}
