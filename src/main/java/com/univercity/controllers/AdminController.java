package com.univercity.controllers;


import com.univercity.model.Role;
import com.univercity.model.User;
import com.univercity.service.interfaces.RoleService;
import com.univercity.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private  UserService userService;

    private  RoleService roleService;


    @RequestMapping(value = "/users_all", method = RequestMethod.GET)
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "users_all";
    }

    @RequestMapping(value = "/delete_user/{userId}", method = RequestMethod.GET)
    public String deleteGet(@PathVariable("userId") long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users_all";
    }

    @RequestMapping(value = "/update_user/{userId}", method = RequestMethod.GET)
    public String updateGet(@PathVariable("userId") long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "update";
}

    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    public String updatePost(@RequestParam("userId") long id, @RequestParam("name") String name,
                             @RequestParam("login") String login, @RequestParam("password") String password,
                             @RequestParam("roles") String [] roles) {
        List<Role> resultRoles = new ArrayList<>();
        for (int i = 0; i < roles.length; i++) {
            Role role = roleService.getByName(roles[i]);
            resultRoles.add(role);
        }

        User user = new User(name, login, password, resultRoles);
        user.setId(id);
        userService.updateUser(user);

        return "redirect:/admin/users_all";
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
