package com.univercity.service.Impl;

import com.univercity.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserService userService;

	@Autowired
	public UserDetailsServiceImpl(UserService userService) {
		this.userService = userService;
	}


	@Override

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		UserDetails user = userService.getByLogin(login);
		if (user == null) {
			throw new UsernameNotFoundException("User" + login + " not found");
		}
		return user;
	}

}
