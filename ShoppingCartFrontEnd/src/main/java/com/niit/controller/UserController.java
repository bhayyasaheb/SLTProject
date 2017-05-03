package com.niit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;

@Controller
public class UserController {
	
	private static Logger log= LoggerFactory.getLogger(UserController.class);

	@Autowired UserDAO userDAO;
	@Autowired User user;
	@Autowired CategoryDAO categoryDAO;
	@Autowired Category category;
	
	// get the user id and password from login page
	// send these values to user to userDAO.validate
	// based on response , you can navigate either login.jsp or Home.jsp
	// whenever we configure spring security - we can remove this method
	
	@RequestMapping("/validate")
	public ModelAndView login(@RequestParam("userName") String id, @RequestParam("password") String password){
		
		log.debug("starting of method login");
		log.info("You are login with "+id);
		
		ModelAndView mv= new ModelAndView("/Home");
		if(userDAO.validate(id, password)== true)
		{
			
			user=userDAO.getUser(id);
			mv.addObject("message", "Welcome "+user.getName());
			mv.addObject("categoryList", categoryDAO.list());
			mv.addObject("category", category);
			
			// check whether user is customer or admin
			
			if(user.getRole().equals("Role_Admin"))
			{
				log.debug("You are Admin");
				mv.addObject("isAdmin","true");
			}
			else{
				log.debug("You are Customer");
				mv.addObject("isAdmin","false");
			}
		}
		else
		{
			log.debug("Invalid Credentials");
			mv.addObject("message", "Invalid credentials ... please try again");
		}
		log.debug("End  of method login");
		return  mv;
	}
}
