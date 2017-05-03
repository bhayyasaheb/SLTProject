package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Product;

public interface ProductDAO {
	
	// create product
	public boolean save(Product product);
	
	// update product
	public boolean update(Product product);
	
	//delete product by id
	public boolean delete(String id);
	
	// delete product by product
	//public boolean delete(Product product);
	
	//get product by id
	public Product getProductById(String id);
	
	//get product by name
	public Product getProductByName(String name);
	
	//get all product
	public List<Product> list();
}
