package com.univercity.service.interfaces;


import com.univercity.model.User;

import java.util.List;

public interface UserService {

	User getByLogin(String login);

	User saveUser(User user);

	List<User>  getAllUsers();

	void deleteUser(long id);

	User getById(long id);

	void updateUser(User user);
}
