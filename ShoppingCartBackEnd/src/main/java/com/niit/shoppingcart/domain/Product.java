package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Product {

	@Id
	private String id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	@Column(name="supplier_id")
	private String supplier_id;
	
	@Column(name="category_id")
	private String category_id;
	
	@ManyToOne
	@JoinColumn(name="category_id",updatable=false,insertable = false, nullable = false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supplier_id",updatable=false,insertable = false, nullable = false)
	private Supplier supplier;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
	
}
