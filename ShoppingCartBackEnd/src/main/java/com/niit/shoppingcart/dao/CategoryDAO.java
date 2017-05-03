package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;

public interface CategoryDAO {
	
	// create category
	public boolean save(Category category);
	
	// update category
	public boolean update(Category category);
	
	//delete category by id
	public boolean delete(String id);
	
	// delete category by category
	//public boolean delete(Category category);
	
	//get category by id
	public Category getCategoryById(String id);
	
	//get category by name
	public Category getCategoryByName(String name);
	
	//get all category
	public List<Category> list();
}
