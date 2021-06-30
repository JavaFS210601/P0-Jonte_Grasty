package com.revature.p0;

public class Customer {

	private int ctr_number, sales_rep_id;
	private String ctr_first_name, ctr_last_name, ctr_phone_number, ctr_email;
	private double ctr_current_balance;

	/**
	 * @param ctr_number
	 * @param ctr_first_name
	 * @param ctr_last_name
	 * @param ctr_phone_number
	 * @param ctr_email
	 * @param ctr_current_balance
	 */
	public Customer(int ctr_number, String ctr_first_name, String ctr_last_name, String ctr_phone_number,
			String ctr_email, double ctr_current_balance, int sales_rep_id) {
		super();
		this.ctr_number = ctr_number;
		this.ctr_first_name = ctr_first_name;
		this.ctr_last_name = ctr_last_name;
		this.ctr_phone_number = ctr_phone_number;
		this.ctr_email = ctr_email;
		this.ctr_current_balance = ctr_current_balance;
		this.sales_rep_id = sales_rep_id;
	}

	/**
	 * @return the ctr_number
	 */
	public int getCtr_number() {
		return ctr_number;
	}

	/**
	 * @return the ctr_first_name
	 */
	public String getCtr_first_name() {
		return ctr_first_name;
	}

	/**
	 * @return the ctr_last_name
	 */
	public String getCtr_last_name() {
		return ctr_last_name;
	}

	/**
	 * @return the ctr_phone_number
	 */
	public String getCtr_phone_number() {
		return ctr_phone_number;
	}

	/**
	 * @return the ctr_email
	 */
	public String getCtr_email() {
		return ctr_email;
	}

	/**
	 * @return the ctr_current_balance
	 */
	public double getCtr_current_balance() {
		return ctr_current_balance;
	}

	/**
	 * @return the sales_rep_id
	 */
	public int getSales_rep_id() {
		return sales_rep_id;
	}

	@Override
	public String toString() {
		return "Customer [ctr_number=" + ctr_number + ", sales_rep_id=" + sales_rep_id + ", ctr_first_name="
				+ ctr_first_name + ", ctr_last_name=" + ctr_last_name + ", ctr_phone_number=" + ctr_phone_number
				+ ", ctr_email=" + ctr_email + ", ctr_current_balance=" + ctr_current_balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ctr_current_balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ctr_email == null) ? 0 : ctr_email.hashCode());
		result = prime * result + ((ctr_first_name == null) ? 0 : ctr_first_name.hashCode());
		result = prime * result + ((ctr_last_name == null) ? 0 : ctr_last_name.hashCode());
		result = prime * result + ctr_number;
		result = prime * result + ((ctr_phone_number == null) ? 0 : ctr_phone_number.hashCode());
		result = prime * result + sales_rep_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (Double.doubleToLongBits(ctr_current_balance) != Double.doubleToLongBits(other.ctr_current_balance))
			return false;
		if (ctr_email == null) {
			if (other.ctr_email != null)
				return false;
		} else if (!ctr_email.equals(other.ctr_email))
			return false;
		if (ctr_first_name == null) {
			if (other.ctr_first_name != null)
				return false;
		} else if (!ctr_first_name.equals(other.ctr_first_name))
			return false;
		if (ctr_last_name == null) {
			if (other.ctr_last_name != null)
				return false;
		} else if (!ctr_last_name.equals(other.ctr_last_name))
			return false;
		if (ctr_number != other.ctr_number)
			return false;
		if (ctr_phone_number == null) {
			if (other.ctr_phone_number != null)
				return false;
		} else if (!ctr_phone_number.equals(other.ctr_phone_number))
			return false;
		if (sales_rep_id != other.sales_rep_id)
			return false;
		return true;
	}

}// end Customer
