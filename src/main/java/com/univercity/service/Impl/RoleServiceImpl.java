package com.univercity.service.Impl;

import com.univercity.model.Role;
import com.univercity.repository.interfaces.RoleRepository;
import com.univercity.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl  implements RoleService{

	private final RoleRepository roleRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Role getByName(String role) {
		return roleRepository.getByName(role);
	}

	@Override
	public List<Role> getAllRoles() {
		List<Role> roles = roleRepository.findAll();
		return  roles;
	}

	@Override
	public void saveRole(Role role) {
		roleRepository.saveAndFlush(role);
	}
}
