package com.collabrationBackend.DAO;

import java.util.List;

import com.collabrationBackend.model.User;

public interface UserDAO {

	//To save update delete user
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(String email);
	
	//To Select User
	public User getUserByEmail(String email);
	public List<User> getAllActiveUser();
	
	//To Active or Deactive User 
	public boolean activeOrdeactiveUser(String email);
	
	//To Give User Authentication
	public boolean validate(String email,String password);
	
}
