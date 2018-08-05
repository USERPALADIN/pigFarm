package com.univercity.repository.interfaces;

import com.univercity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
	User getByLogin(String login);

}
