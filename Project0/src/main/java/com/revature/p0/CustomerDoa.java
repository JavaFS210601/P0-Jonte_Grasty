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

public class CustomerDoa implements CustomerDoaInterface {

	final Logger log = LogManager.getLogger(Menu.class);

	@Override
	public List<Customer> listCustomers() {

		try (Connection conn = ConnectionUtil.getConnection()) {

			ResultSet rs = null;
			String sql = "SELECT * FROM customers;";
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);

			List<Customer> customerList = new ArrayList<>();

			while (rs.next()) {

				Customer customer = new Customer(
						rs.getInt("ctr_number"), 
						rs.getString("ctr_first_name"),
						rs.getString("ctr_last_name"),
						rs.getString("ctr_phone_number"),
						rs.getString("ctr_email"), 
						rs.getDouble("ctr_current_balance"),
						rs.getInt("sales_rep_id")
						);

				customerList.add(customer);
				
			} // end while
			
			log.info("End-user viewed customer list");
			return customerList;

		} catch (SQLException e) { // if something goes wrong accessing our data, it will get caught
			System.out.println("Something went wrong when trying to access your DB");
			e.printStackTrace();
		}

		return null;
	}// listCustomers

	@Override
	public void addCustomer(Customer customer) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO customers (ctr_number, ctr_first_name, ctr_last_name, "
					+ "ctr_phone_number, ctr_email, ctr_current_balance, sales_rep_id)" + "VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, customer.getCtr_number());
			ps.setString(2, customer.getCtr_first_name());
			ps.setString(3, customer.getCtr_last_name());
			ps.setString(4, customer.getCtr_phone_number());
			ps.setString(5, customer.getCtr_email());
			ps.setDouble(6, customer.getCtr_current_balance());
			ps.setInt(7, customer.getSales_rep_id());
			ps.executeUpdate();

			System.out.println("New customer: " + customer.getCtr_first_name() + " added!");
			log.info("End-user added customer");

		} catch (SQLException e) {
			System.out.println("New customer not added.");
			e.printStackTrace();
		} // end try-catch

	}// end newProfile

	@Override
	public void removeCustomer(int ctr_number) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "DELETE FROM customers WHERE ctr_number = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, ctr_number);
//		
			ps.executeUpdate();

			System.out.println("Customer: " + ctr_number + " removed!");
			log.info("End-user removed customer");

		} catch (SQLException e) {
			System.out.println("Customer not deleted!");
			e.printStackTrace();

		} // end try-catch

	}

}// end CustomerProfile
