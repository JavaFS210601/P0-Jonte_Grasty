package com.revature.p0;

import java.sql.Connection;
import java.sql.SQLException;

public class ECommerceMain {

	public static void main(String[] args) {
	
		try(Connection conn = ConnectionUtil.getConnection()){
			
			System.out.println("Connection successful!");
			System.out.println("***********************\n");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Displays the main menu.
		// User selects options to display.
		Menu menu = new Menu();
		menu.mainMenu();
		
	}// end main

}// end ECommerceMain
