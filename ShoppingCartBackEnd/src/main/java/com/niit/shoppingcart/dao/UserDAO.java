package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.User;

public interface UserDAO {
	
	// declare  the methods 
	// what type of operation you are going to do user
	
	//operations 
	// 1)create /register -save
	// 2) update the user details  -update
	// 3) validate the credentials -validate 
	// 4) get all the users -list
	// 5) get user details based on userId
	
	//declare the methods with proper signature 
	// access_ specifier return_type method-name(parameter_list) throws exception_list
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	// we are going to use spring security in future
	// we can delete this method after using spring security
	public boolean validate(String id, String password);
	
	public List<User> list();
	
	public User getUser(String id);
}
