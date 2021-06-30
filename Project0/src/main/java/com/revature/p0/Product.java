package com.revature.p0;

public class Product {
	private int product_number;
	private String product_name, product_description, product_category;
	private double product_price;

	/**
	 * @param ctr_number
	 * @param product_number
	 * @param product_name
	 * @param product_description
	 * @param product_category
	 */
	public Product(int product_number, String product_name, String product_description, String product_category,
			double product_price) {
		super();
		this.product_number = product_number;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_category = product_category;
		this.product_price = product_price;

	}

	public double getProduct_price() {
		return product_price;
	}

	public int getProduct_number() {
		return product_number;
	}

	public String getProduct_name() {
		return product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public String getProduct_category() {
		return product_category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product_category == null) ? 0 : product_category.hashCode());
		result = prime * result + ((product_description == null) ? 0 : product_description.hashCode());
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		result = prime * result + product_number;
		long temp;
		temp = Double.doubleToLongBits(product_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Product other = (Product) obj;
		if (product_category == null) {
			if (other.product_category != null)
				return false;
		} else if (!product_category.equals(other.product_category))
			return false;
		if (product_description == null) {
			if (other.product_description != null)
				return false;
		} else if (!product_description.equals(other.product_description))
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (product_number != other.product_number)
			return false;
		if (Double.doubleToLongBits(product_price) != Double.doubleToLongBits(other.product_price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [product_number=" + product_number + ", product_name=" + product_name + ", product_description="
				+ product_description + ", product_category=" + product_category + ", product_price=" + product_price
				+ "]";
	}

}// end Products
