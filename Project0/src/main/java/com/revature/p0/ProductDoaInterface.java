package com.revature.p0;

import java.util.List;

public interface ProductDoaInterface {
	public List<Product> listProducts();
	public void addProduct(Product product);
	public void removeProduct(int product_number);
	
}
