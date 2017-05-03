package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductTestCase {

	// because we use annotation like @Repository,@Component,@Configuration
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Product product;

	@Autowired
	static ProductDAO productDAO;

	@BeforeClass
	public static void initialization() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");// scan the complete class
		context.refresh(); //
		productDAO = (ProductDAO) context.getBean("productDAO");

		product = (Product) context.getBean("product");
	}
	
	//@Test
	public void createProductTestCase(){
		
		product.setId("P103");
		product.setName("LED");
		product.setDescription("Samsung LED HD 32 inch");
		product.setPrice(35000);
		product.setCategory_id("C300");
		product.setSupplier_id("S222");
		
		boolean flag = productDAO.save(product);
		assertEquals("createProductTestcase", true, flag);
	}
	
	//@Test
	public void updateTestCase(){
		
		product.setId("P101");
		product.setName("Laptop");
		product.setDescription("Dell Insiron 5548 i5 8 GB RAM and 1 TB ROM with Touch pad ");
		product.setPrice(59000);
		product.setCategory_id("C300");
		product.setSupplier_id("S111");
		
		boolean flag = productDAO.update(product);
		assertEquals("updateProductTestCase", true, flag);
	}

	//@Test
	public void deleteProductTestCase(){
		
		boolean flag = productDAO.delete("P103");
		assertEquals("deleteProductTestcase", true, flag);
	}
	
	@Test
	public void getProductById(){
		
		product = productDAO.getProductById("P101");
		assertEquals(product.getClass().getName(), product.getClass().getName());
	}
	@Test
	public void getAllProductTestCase() {

		List<Product> product = productDAO.list();
		assertEquals(2, product.size());
	}
}
