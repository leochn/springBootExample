package com.example.service.impl;

import org.springframework.stereotype.Service;

import com.example.pojo.User;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User getById(String id) {
		User user = new User();
		user.setId(id);
		user.setName("example");
		user.setAddress("shanghai");
		user.setAge(18);
		return user;
	}

}
