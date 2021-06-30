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

public class SalesRepDoa implements SalesRepDoaInterface {

	final Logger log = LogManager.getLogger(Menu.class);

	@Override
	public List<SalesRep> listSalesReps() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			ResultSet rs = null;
			String sql = "SELECT * FROM sales_representatives;";
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);

			List<SalesRep> salesRepList = new ArrayList<>();

			while (rs.next()) {

				SalesRep salesRep = new SalesRep(rs.getInt("sales_rep_id"), rs.getString("sales_rep_first_name"),
						rs.getString("sales_rep_last_name"), rs.getString("sales_rep_phone_number"),
						rs.getString("sales_rep_email"), rs.getInt("ctr_number"));

				salesRepList.add(salesRep);

			} // end while
			
			log.info("End-user viewed sales rep list");
			return salesRepList;

		} catch (SQLException e) { // if something goes wrong accessing our data, it will get caught
			System.out.println("Something went wrong when trying to access your DB");
			e.printStackTrace();
		}// end try-catch
		return null;
	}// end listSalesRep

	@Override
	public void addSalesRep(SalesRep salesRep) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO sales_representatives (sales_rep_id, sales_rep_first_name, sales_rep_last_name,"
					+ "sales_rep_phone_number, sales_rep_email, ctr_number)" + "VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, salesRep.getSales_rep_id());
			ps.setString(2, salesRep.getSales_rep_first_name());
			ps.setString(3, salesRep.getSales_rep_last_name());
			ps.setString(4, salesRep.getSales_rep_phone_number());
			ps.setString(5, salesRep.getSales_rep_email());
			ps.setInt(6, salesRep.getCtr_number());
			ps.executeUpdate();

			System.out.println("New sales rep: " + salesRep.getSales_rep_first_name() + " added!");
			log.info("End-user added sales rep");

		} catch (SQLException e) {
			System.out.println("New sales rep not added.");
			e.printStackTrace();
		} // end try-catch
		
	}// end addSalesRep

	@Override
	public void removeSalesRep(int sales_rep_id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "DELETE FROM sales_representatives WHERE sales_rep_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, sales_rep_id);
//		
			ps.executeUpdate();

			System.out.println("Sales rep: " + sales_rep_id + " removed!");
			log.info("End-user removed sales rep");

		} catch (SQLException e) {
			System.out.println("Sales rep not deleted!");
			e.printStackTrace();

		} // end try-catch

	}// end removeSalesrep
}// end SalesRepDoa
