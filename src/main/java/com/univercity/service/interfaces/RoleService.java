package com.univercity.service.interfaces;

import com.univercity.model.Role;

import java.util.List;

public interface RoleService {

	Role getByName(String role);

	List<Role> getAllRoles();

	void saveRole(Role role);
}
