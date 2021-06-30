package com.revature.p0;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu {
	CustomerDoa custDoa = new CustomerDoa();
	SalesRepDoa salesRepDoa = new SalesRepDoa();
	ProductDoa productDoa = new ProductDoa();

	static Scanner keyboard = new Scanner(System.in);
	final Logger log = LogManager.getLogger(Menu.class);

	public void mainMenu() {

		boolean displayMenu = true;

		// Greeting end-user
		System.out.println("-----------------------------------");
		System.out.println("E-Commerce Product Management");
		System.out.println("-----------------------------------\n");

		// Display menu options so long as displayMenu is true
		while (displayMenu) {

			// Menu options
			System.out.println("--------------------------------");
			System.out.println("Select an option: ");
			System.out.println("0 - Exit");
			System.out.println("1 - Products");
			System.out.println("2 - Customers");
			System.out.println("3 - Sales Reps");
			System.out.println("--------------------------------\n");

			// Parse user input after menu selection.
			int menuInput = keyboard.nextInt();

			// Switch on user's menuInput from keyboard.
			switch (menuInput) {

			case 0: {
				System.out.println("System Exit");
				System.exit(0);
				break;
			}

			case 1: {
				System.out.println("---------------------");
				System.out.println("Product Menu");
				System.out.println("Select an option:");
				System.out.println("0 - Exit");
				System.out.println("1 - Add Product");
				System.out.println("2 - Remove Product");
				System.out.println("3 - Show All Products");
				System.out.println("----------------------\n");
				int menuInput2 = keyboard.nextInt();
				productMenu(menuInput2);
				break;
			}

			case 2: {
				System.out.println("---------------------");
				System.out.println("Customer Menu");
				System.out.println("Select an option:");
				System.out.println("0 - Exit");
				System.out.println("1 - Add Customer");
				System.out.println("2 - Remove Customer");
				System.out.println("3 - Show All Customer");
				System.out.println("----------------------\n");
				int menuInput2 = keyboard.nextInt();
				customerMenu(menuInput2);
				break;
			}

			case 3: {
				System.out.println("---------------------");
				System.out.println("Sales Representative Menu");
				System.out.println("Customer Menu");
				System.out.println("Select an option:");
				System.out.println("0 - Exit");
				System.out.println("1 - Add Sales Rep");
//				System.out.println("2 - Remove Sales Rep");
				System.out.println("2 - Show All Sales Reps");
				System.out.println("----------------------\n");
				int menuInput2 = keyboard.nextInt();
				salesRepMenu(menuInput2);
				break;
			}

			default: {
				System.out.println("Select a valid option. Please Try again");
//				mainMenu();
			}

			}// end switch

		} // end while
	}// end mainMenu()

	public void customerMenu(int menuInput2) {

		switch (menuInput2) {
		case 0: {
			System.out.println("System Exit");
			System.exit(0);
			break;
		}

		case 1: {
			System.out.println("Add Customer to database");

			System.out.println("Enter the 6-Digit Customer Id: ");
			int cus_number = keyboard.nextInt();
			keyboard.nextLine();

			System.out.println("Enter Customer's First Name: ");
			String cus_first_name = keyboard.nextLine();

			System.out.println("Enter Customer's Last Name: ");
			String cus_last_name = keyboard.nextLine();

			System.out.println("Enter Customer's Phone Number: ");
			String cus_phone_number = keyboard.nextLine();

			System.out.println("Enter Customer's Email: ");
			String cus_email = keyboard.nextLine();

			System.out.println("Enter Customer's Current Balance: ");
			double cus_current_balance = keyboard.nextDouble();

			System.out.println("Enter the 4-Digit Sales Rep Id#: ");
			getSalesRep();
			int sales_rep_id = keyboard.nextInt();

			Customer newCustomer = new Customer(cus_number, cus_first_name, cus_last_name, cus_phone_number, cus_email,
					cus_current_balance, sales_rep_id);

			custDoa.addCustomer(newCustomer);

			break;
		}

		case 2: {
			log.warn("End-user attempted to delete customer");
			System.out.println("Remove Customer from database");
			getCustomers();
			System.out.println("Enter the customer number of the customer to be deleted: ");
			int cus_num = keyboard.nextInt();
			keyboard.nextLine();

			custDoa.removeCustomer(cus_num);
			break;
		}

		case 3: {
			System.out.println("Preparing to display all customers...\n");
			getCustomers();
			System.out.println("\n---- End of customer list ----");// line break
			break;
		}

		default: {
			System.out.println("Select a valid option. Please Try again");
			break;
		}

		}// end switch
	}// end customerMenu

	public void salesRepMenu(int menuInput2) {

		switch (menuInput2) {
		case 0: {
			System.out.println("System Exit");
			System.exit(0);
			break;
		}

		case 1: {
			System.out.println("Add Sales Rep to database");

			System.out.println("Enter the 4-Digit Sales Rep Id#: ");
			int sales_rep_id = keyboard.nextInt();
			keyboard.nextLine();

			System.out.println("Enter Sales Rep's First Name: ");
			String sales_rep_first_name = keyboard.nextLine();

			System.out.println("Enter Sales Rep's Last Name: ");
			String sales_rep_last_name = keyboard.nextLine();

			System.out.println("Enter Sales Rep's Phone Number: ");
			String sales_rep_phone_number = keyboard.nextLine();

			System.out.println("Enter Sales Rep's Email: ");
			String sales_rep_email = keyboard.nextLine();

			SalesRep newSalesRep = new SalesRep(sales_rep_id, sales_rep_first_name, sales_rep_last_name,
					sales_rep_phone_number, sales_rep_email);

			salesRepDoa.addSalesRep(newSalesRep);

			break;
		}

//		case 2: {
//			log.warn("End-user attempted to delete sales rep");
//			System.out.println("Remove sales rep from database");
//			getSalesRep();
//			System.out.println("Enter the sales rep id of the sales rep to be deleted: ");
//			int sales_rep_id = keyboard.nextInt();
//			keyboard.nextLine();
//
//			salesRepDoa.removeSalesRep(sales_rep_id);
//			break;
//		}

		case 2: {
			System.out.println("Preparing to display all sales reps...\n");
			getSalesRep();
			System.out.println("\n---- End of sales rep list ----");// line break
			break;
		}

		default: {
			System.out.println("Select a valid option. Please Try again");
			break;
		}

		}// end switch
	}// end customerMenu

	public void productMenu(int menuInput2) {

		switch (menuInput2) {
		case 0: {
			System.out.println("System Exit");
			System.exit(0);
			break;
		}

		case 1: {
			System.out.println("Add Product to database");

			System.out.println("Enter the 8-Digit Product Number: ");
			int product_number = keyboard.nextInt();
			keyboard.nextLine();

			System.out.println("Enter Product Name: ");
			String product_name = keyboard.nextLine();

			System.out.println("Enter Product Description: ");
			String product_description = keyboard.nextLine();

			System.out.println("Enter Product Category: ");
			String product_category = keyboard.nextLine();
			
			System.out.println("Enter Product Price: ");
			double product_price = keyboard.nextDouble();

			Product products = new Product(product_number, product_name, product_description, product_category, product_price);

			productDoa.addProduct(products);

			break;
		}

		case 2: {
			log.warn("End-user attempted to delete product");
			System.out.println("Remove product from database");
			getProducts();
			System.out.println("Enter the product to be deleted: ");
			int product_number = keyboard.nextInt();
			keyboard.nextLine();

			productDoa.removeProduct(product_number);
			break;
		}

		case 3: {
			System.out.println("Preparing to display all products...\n");
			getProducts();
			System.out.println("\n---- End of products list ----");// line break
			break;
		}

		default: {
			System.out.println("Select a valid option. Please Try again");
			break;
		}

		}// end switch
	}// end customerMenu

	public void getProducts() {
		List<Product> products = productDoa.listProducts();

		for (Product p : products) {
			System.out.println("Product#: " + p.getProduct_number() + ", Product: " + p.getProduct_name()
					+ ", Description: " + p.getProduct_description() + ", Category: " + p.getProduct_category() + ", Price: " + p.getProduct_price());
		}
	}

	public void getCustomers() {
		List<Customer> customers = custDoa.listCustomers();

		for (Customer c : customers) {
			System.out.println("Customer#: " + c.getCtr_number() + ", Customer: " + c.getCtr_first_name() + " "
					+ c.getCtr_last_name() + ", Phone: " + c.getCtr_phone_number() + ", Email: " + c.getCtr_email()
					+ ", Balance: " + c.getCtr_current_balance());
		}
	}

	public void getSalesRep() {
		List<SalesRep> salesReps = salesRepDoa.listSalesReps();

		for (SalesRep sr : salesReps) {
			System.out.println("Rep Id#: " + sr.getSales_rep_id() + ", Rep: " + sr.getSales_rep_first_name() + " "
					+ sr.getSales_rep_last_name() + ", Phone: " + sr.getSales_rep_phone_number() + ", Email: "
					+ sr.getSales_rep_email());
		}
	}
}// end Class