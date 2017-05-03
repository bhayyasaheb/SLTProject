package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Controller
public class CategoryController {

	// create category
	// fetch all category
	// delete category
	// update category
	@Autowired
	HttpSession session;

	// SLF4J--> simple logging Facade for java
	private static Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;

	@RequestMapping("/manage_category_add")
	public ModelAndView createCategory(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description) {
		log.debug("Starting of the Method Create Categories");

		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		ModelAndView mv = new ModelAndView("forward:/manageCategories");
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		// before calling save method check whether the category id already
		// exist in db or not
		// if it is does not exist , then only call save method

		if (categoryDAO.getCategoryById(id) != null) {
			// category all ready exist
			mv.addObject("message", "Category already exist with this id" + id);
			return mv;
		} else // actually else is not required if return statement is their in
				// if condition
		{
			categoryDAO.save(category);
			mv.addObject("message", "Category Created Sucessfully");
		}
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);

		return mv;
	}

	@RequestMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id) {

		log.debug("Starting of the Method delete Categories");
		log.info("You are going to delete" + id);
		ModelAndView mv = new ModelAndView("forward:/manageCategories");
		mv.addObject("message", "Sucessfully Deleted Category");
		if (categoryDAO.delete(id)) {
			mv.addObject("message", "Sucessfully Deleted Category");
		} else {
			mv.addObject("message", "Category Can not be deleted");
		}
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);

		log.debug("End of the method delete Category");
		return mv;
	}

	// http://localhost:8080/ShoppingCartFrontEnd/manage_category_edit/C700
	@RequestMapping("/manage_category_edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") String id) {

		log.debug("starting of the method edit category");
		log.debug("Going to edit category:" + id);
		category = categoryDAO.getCategoryById(id);
		// selected category details we have to store i another instance in
		// ModelAndView instance

		ModelAndView mv = new ModelAndView("forward:/manageCategories");
		mv.addObject("selectedCategory", category);
		log.debug("End of the method edit category");
		return mv;

	}

	@RequestMapping("/manage_category_edit/manage_category_update")
	public ModelAndView updateCategory(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description) {
		
		log.debug("Starting of the Method update Categories");
		log.debug("Going to edit the Category :"+id);
		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		ModelAndView mv = new ModelAndView("forward:/manageCategories");
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		// before calling save method check whether the category id already
		// exist in db or not
		// if it is does not exist , then only call save method

		if (categoryDAO.getCategoryById(id) != null) {
			// category all ready exist
			mv.addObject("message", "Category already exist with this id" + id);
			categoryDAO.update(category);
			log.debug("Updated category Successfully");
			return mv;
		} else // actually else is not required if return statement is their in
				// if condition
		{
			
			mv.addObject("message", "Category Created Sucessfully");
		}
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);

		log.debug("End of the method Update Categories");
		return mv;
	}
}
