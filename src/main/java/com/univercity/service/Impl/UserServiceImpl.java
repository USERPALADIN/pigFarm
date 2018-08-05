package com.univercity.service.Impl;

import com.univercity.model.User;
import com.univercity.repository.interfaces.UserRepository;
import com.univercity.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private  PasswordEncoder passwordEncoder;
	private  UserRepository userRepository;

	@Override
	public User getByLogin(String login) {
		return  userRepository.getByLogin(login);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.saveAndFlush(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User getById(long id) {
		return  userRepository.getOne(id);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.saveAndFlush(user);
	}

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
