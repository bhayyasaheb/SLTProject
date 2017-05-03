package com.niit.shoppingcart.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Supplier {

	@Id
	private String id;
	
	private String name;
	
	private String address;
	
	// If the relation is one-to-many we need to use the following
	@OneToMany(mappedBy="supplier",fetch=FetchType.LAZY)
	private Set<Product> products;
	
	/*
	 * Each category may have n number of products. We use Set instead of List
	 * because Set does not have duplicates.
	 */
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}


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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

		
	
}
