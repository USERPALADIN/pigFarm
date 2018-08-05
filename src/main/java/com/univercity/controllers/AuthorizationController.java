package com.univercity.controllers;

import com.univercity.model.Role;
import com.univercity.model.User;
import com.univercity.service.interfaces.RoleService;
import com.univercity.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorizationController {

	private final UserService userService;
	private final RoleService roleService;

	@Autowired
	public AuthorizationController(RoleService roleService, UserService userService) {
		this.roleService = roleService;
		this.userService = userService;
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String loginGet(Model model) {
		return "login";
	}

	@RequestMapping(value = "/insert_user", method = RequestMethod.GET)
	public String insertGet(Model model) {
		return "addUser";
	}


	@RequestMapping(value = "/insert_user", method = RequestMethod.POST)
	public String insertPost(@RequestParam("name") String name, @RequestParam("login") String login, @RequestParam("password") String password) {
		String name_Role = "ROLE_NEW";
		List<Role> roles = new ArrayList<>();
		Role role = roleService.getByName(name_Role);
		roles.add(role);
		User user = new User(name, login, password, roles);
		userService.saveUser(user);
		return "login";
	}
}
