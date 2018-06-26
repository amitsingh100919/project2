package com.collabrationMiddle.RestConroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabrationBackend.DAO.UserDAO;
import com.collabrationBackend.model.User;

@RestController
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@GetMapping("/getAllUser")
	public ResponseEntity<?> getAllUser(){
		List<User> userList=userDAO.getAllActiveUser();
		if(userList==null) {
			return new ResponseEntity<String>("There is no user added",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
		}
			
		
	}
	@PostMapping("/registerUser")
	public ResponseEntity<?> registerUser(@RequestBody User user)
	{
		System.out.println("Register User");
		User ob=new User();
		ob.setActive(user.isActive());
		ob.setEmail(user.getEmail());
		ob.setFirstname(user.getFirstname());
		ob.setLastname(user.getLastname());
		ob.setMobile(user.getMobile());
		ob.setPassword(user.getPassword());
		ob.setRole(user.getRole());
		ob.setOnline(user.isOnline());
		
		if(userDAO.registerUser(ob)) {
			return new ResponseEntity<String>("Registered user successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Can not register user successfully",HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User user)
	{
		System.out.println("Update User");
		System.out.println(user.getEmail());
		User ob=new User();
		ob.setActive(user.isActive());
		ob.setEmail(user.getEmail());
		ob.setFirstname(user.getFirstname());
		ob.setLastname(user.getLastname());
		ob.setMobile(user.getMobile());
		ob.setPassword(user.getPassword());
		ob.setRole(user.getRole());
		ob.setOnline(user.isOnline());
		ob = userDAO.getUserByEmail(user.getEmail());
			if(user.getFirstname()!=null)
			{
				ob.setFirstname(user.getFirstname());
			}
		ob = userDAO.getUserByEmail(user.getEmail());
			if(user.getLastname()!=null)
			{
				ob.setLastname(user.getLastname());
			}
		ob = userDAO.getUserByEmail(user.getEmail());
			if(user.getMobile()!=null)
			{
				ob.setMobile(user.getMobile());
			}
		ob = userDAO.getUserByEmail(user.getEmail());
			if(user.getEmail()!=null)
			{
				ob.setEmail(user.getEmail());
			}
		ob = userDAO.getUserByEmail(user.getEmail());
			if(user.getPassword()!=null)
			{
				ob.setPassword(user.getPassword());
			}
		ob = userDAO.getUserByEmail(user.getEmail()); 
			if(user.getRole()!=null)
			{
				ob.setRole(user.getRole());
			}
		if(userDAO.updateUser(ob)) {
			return new ResponseEntity<String>("Updated user successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Can not update user ",HttpStatus.NOT_FOUND);
		}

	}
	@PostMapping("/deleteUser/{email}")
	public ResponseEntity<?> deleteUser(@PathVariable("email") String email){
		System.out.println("Delete user" + email+".com");
		User user = userDAO.getUserByEmail(email+".com");
		if(user==null)
		{
			System.out.println("No user with email " + email + " found to delete");
			return new ResponseEntity<String>("No user found to delete",HttpStatus.NOT_FOUND);
		}
		else
		{
			userDAO.deleteUser(email);
			return new ResponseEntity<String>("User with email " + email + " deleted successfully", HttpStatus.OK);
		}
		
	}
	@PostMapping("/getUser/{email}")
	public ResponseEntity<?> getUser(@PathVariable("email") String email){
		
		User user = userDAO.getUserByEmail(email+".com");
		if(user==null)
		{
			System.out.println("No user found="+email);
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
			
		}else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
}
