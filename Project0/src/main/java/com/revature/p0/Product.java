package com.revature.p0;

public class Product {
	private int ctr_number, product_number;
	private String product_name, product_description, product_category;

	/**
	 * @param ctr_number
	 * @param product_number
	 * @param product_name
	 * @param product_description
	 * @param product_category
	 */
	public Product(int product_number, String product_name, String product_description,
			String product_category, int ctr_number) {
		super();
		this.ctr_number = ctr_number;
		this.product_number = product_number;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_category = product_category;
	}

	/**
	 * @return the ctr_number
	 */
	public int getCtr_number() {
		return ctr_number;
	}

	/**
	 * @return the product_number
	 */
	public int getProduct_number() {
		return product_number;
	}

	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}

	/**
	 * @return the product_description
	 */
	public String getProduct_description() {
		return product_description;
	}

	/**
	 * @return the product_category
	 */
	public String getProduct_category() {
		return product_category;
	}

	/**
	 * @param ctr_number the ctr_number to set
	 */
	public void setCtr_number(int ctr_number) {
		this.ctr_number = ctr_number;
	}

	/**
	 * @param product_number the product_number to set
	 */
	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}

	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	/**
	 * @param product_description the product_description to set
	 */
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	/**
	 * @param product_category the product_category to set
	 */
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	@Override
	public String toString() {
		return "Product [ctr_number=" + ctr_number + ", product_number=" + product_number + ", product_name="
				+ product_name + ", product_description=" + product_description + ", product_category="
				+ product_category + "]";
	}

	
}// end Products
