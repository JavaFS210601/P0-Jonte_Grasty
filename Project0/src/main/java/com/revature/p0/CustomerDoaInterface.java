package com.revature.p0;

import java.util.List;

public interface CustomerDoaInterface {

	public List<Customer> listCustomers();
	public void addCustomer(Customer customer);
	public void removeCustomer(int ctr_number);

}// end CustomerDoaInterface
