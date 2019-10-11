package com.sapient.userservice.service;


import java.util.List;
import java.util.Optional;

import com.sapient.userservice.model.User;

public interface UserService{
	public User createUser(User user);
	public User updateUser(User user) ;
	public List<User> getAllUsers();
	public User getUserByUsername(String username);

}
