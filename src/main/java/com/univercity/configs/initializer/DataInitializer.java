package com.univercity.configs.initializer;

import com.univercity.model.Role;
import com.univercity.model.Unit;
import com.univercity.model.User;
import com.univercity.service.interfaces.RoleService;
import com.univercity.service.interfaces.UnitService;
import com.univercity.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Autowired
	private UnitService unitService;

	public void init() {
		Role role1 = new Role("ROLE_ADMIN");
		Role role2 = new Role("ROLE_USER");
		Role role3 = new Role("ROLE_NEW");
		roleService.saveRole(role1);
		roleService.saveRole(role2);
		roleService.saveRole(role3);

		List<Role> roleList = new ArrayList<>();
		roleList.add(role1);
		roleList.add(role2);
		roleList.add(role3);

		Unit unit = new Unit("руб/кг");
		Unit unit2 = new Unit("руб/л");

		unitService.addUnit(unit);
		unitService.addUnit(unit2);

		User  user = new User("qwer", "qwer", "qwer",roleList);
		userService.saveUser(user);

	}
}
