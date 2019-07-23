package com.sb.sc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sb.sc.data.UserRepository;
import com.sb.sc.model.User;

@Controller
public class UserController {

	@Autowired
	private UserRepository userData;

	@RequestMapping(value = "/addNewUser.html", method = RequestMethod.POST)
	public String newEmployee(User user) {

		userData.save(user);
		return ("redirect:/listUsers.html");

	}
	

	@RequestMapping(value = "/addNewUser.html", method = RequestMethod.GET)
	public ModelAndView addNewUser() {

		User emp = new User();
		return new ModelAndView("newUser", "form", emp);

	}

	@RequestMapping(value = "/listUser.html", method = RequestMethod.GET)
	public ModelAndView users() {
		List<User> allUsers = userData.findAll();
		return new ModelAndView("allUsers", "users", allUsers);

	}

}
