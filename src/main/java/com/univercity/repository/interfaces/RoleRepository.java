package com.univercity.repository.interfaces;

import com.univercity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
	Role getByName(String role);
}
