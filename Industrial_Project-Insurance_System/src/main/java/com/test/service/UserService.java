package com.test.service;

import com.test.entity.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public User registerUser(User user);
	
    public boolean login(String email, String password);

}
