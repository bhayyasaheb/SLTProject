package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

public class CategoryTestCase {

	// because we use annotation like @Repository,@Component,@Configuration
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Category category;

	@Autowired
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void initialization() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");// scan the complete class
		context.refresh(); //
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

		category = (Category) context.getBean("category");
	}
	
	//@Test
	public void createCategoryTestCase(){
		
		category.setId("C500");
		category.setName("Book");
		category.setDescription("Books Category");
		
		boolean flag = categoryDAO.save(category);
		assertEquals("createCategoryTestcase", true, flag);
	}
	
	//@Test
	public void updateTestCase(){
		
		category.setId("C500");
		category.setName("Books");
		category.setDescription("Books Category");
		
		boolean flag = categoryDAO.update(category);
		assertEquals("updateCategoryTestCase", true, flag);
	}

	//@Test
	public void deleteCategoryTestCase(){
		
		boolean flag = categoryDAO.delete("C600");
		assertEquals("deleteCategoryTestcase", true, flag);
	}
	
	@Test
	public void getCategoryById(){
		
		category = categoryDAO.getCategoryById("C100");
		assertEquals(category.getClass().getName(), category.getClass().getName());
	}
	@Test
	public void getAllCategoryTestCase() {

		List<Category> category = categoryDAO.list();
		assertEquals(5, category.size());
	}
}
