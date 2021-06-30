package com.revature.p0;

public class SalesRep {
	private int sales_rep_id;
	private String sales_rep_first_name, sales_rep_last_name, sales_rep_phone_number, sales_rep_email;

	/**
	 * @param sales_rep_id
	 * @param ctr_number
	 * @param sales_rep_first_name
	 * @param sales_rep_last_name
	 * @param sales_rep_phone_number
	 * @param sales_rep_email
	 */

	public SalesRep(int sales_rep_id, String sales_rep_first_name, String sales_rep_last_name,
			String sales_rep_phone_number, String sales_rep_email) {
		super();
		this.sales_rep_id = sales_rep_id;
		this.sales_rep_first_name = sales_rep_first_name;
		this.sales_rep_last_name = sales_rep_last_name;
		this.sales_rep_phone_number = sales_rep_phone_number;
		this.sales_rep_email = sales_rep_email;
	}

	public int getSales_rep_id() {
		return sales_rep_id;
	}

	public String getSales_rep_first_name() {
		return sales_rep_first_name;
	}

	public String getSales_rep_last_name() {
		return sales_rep_last_name;
	}

	public String getSales_rep_phone_number() {
		return sales_rep_phone_number;
	}

	public String getSales_rep_email() {
		return sales_rep_email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sales_rep_email == null) ? 0 : sales_rep_email.hashCode());
		result = prime * result + ((sales_rep_first_name == null) ? 0 : sales_rep_first_name.hashCode());
		result = prime * result + sales_rep_id;
		result = prime * result + ((sales_rep_last_name == null) ? 0 : sales_rep_last_name.hashCode());
		result = prime * result + ((sales_rep_phone_number == null) ? 0 : sales_rep_phone_number.hashCode());
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
		SalesRep other = (SalesRep) obj;
		if (sales_rep_email == null) {
			if (other.sales_rep_email != null)
				return false;
		} else if (!sales_rep_email.equals(other.sales_rep_email))
			return false;
		if (sales_rep_first_name == null) {
			if (other.sales_rep_first_name != null)
				return false;
		} else if (!sales_rep_first_name.equals(other.sales_rep_first_name))
			return false;
		if (sales_rep_id != other.sales_rep_id)
			return false;
		if (sales_rep_last_name == null) {
			if (other.sales_rep_last_name != null)
				return false;
		} else if (!sales_rep_last_name.equals(other.sales_rep_last_name))
			return false;
		if (sales_rep_phone_number == null) {
			if (other.sales_rep_phone_number != null)
				return false;
		} else if (!sales_rep_phone_number.equals(other.sales_rep_phone_number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SalesRep [sales_rep_id=" + sales_rep_id + ", sales_rep_first_name=" + sales_rep_first_name
				+ ", sales_rep_last_name=" + sales_rep_last_name + ", sales_rep_phone_number=" + sales_rep_phone_number
				+ ", sales_rep_email=" + sales_rep_email + "]";
	}

}// end SalesRep
