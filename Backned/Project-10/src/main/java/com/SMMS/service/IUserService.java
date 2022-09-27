package com.SMMS.service;

import com.SMMS.entities.User;

public interface IUserService {
	
	//to authenticate user
	public Object authenticateUser(User user);
	
	//to register user
	public Object registerUser(User user);
}
