package com.niit.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

public class SupplierTestCase {

	// because we use annotation like @Repository,@Component,@Configuration
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Supplier supplier;

	@Autowired
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void initialization() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");// scan the complete class
		context.refresh(); //
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		supplier = (Supplier) context.getBean("supplier");
	}
	
	//@Test
	public void createSupplierTestCase(){
		
		supplier.setId("S555");
		supplier.setName("Nike Techno");
		supplier.setAddress("Pune");
		
		boolean flag = supplierDAO.save(supplier);
		assertEquals("createSupplierTestcase", true, flag);
	}
	
	//@Test
	public void updateTestCase(){
		
		supplier.setId("S222");
		supplier.setName("soft solution");
		supplier.setAddress("Hydrabad");
		
		
		boolean flag = supplierDAO.update(supplier);
		assertEquals("updateSupplierTestCase", true, flag);
	}

	//@Test
	public void deleteSupplierTestCase(){
		
		boolean flag = supplierDAO.delete("S555");
		assertEquals("deleteSupplierTestcase", true, flag);
	}
	
	@Test
	public void getSupplierById(){
		
		supplier = supplierDAO.getSupplierById("S111");
		assertEquals(supplier.getClass().getName(), supplier.getClass().getName());
	}
	@Test
	public void getAllSupplierTestCase() {

		List<Supplier> supplier = supplierDAO.list();
		assertEquals(4, supplier.size());
	}
}
