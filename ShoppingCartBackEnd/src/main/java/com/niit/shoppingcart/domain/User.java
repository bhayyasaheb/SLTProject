package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

// need to create singleton instance of this class

@Component
@Entity
@Table(name="User")  // if the table name and domian name different 
public class User {
	
	// we have define all the properties for all the fields in table
	
	// we have mention which one is primary key 
	
	@Id
	private String id;
	
	@Column(name="name")	// if the field name in the table and properties in class are different we required to specify cloumn name
	private String name;
	
	private String password;
	
	private String role;
	
	private String contact;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
