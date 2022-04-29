package com.ABCBank.ABC.ABCBank.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ABCBank.ABC.ABCBank.Services.UserService;
import com.ABCBank.ABC.ABCBank.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/CreateUser")
	public User createUser(@RequestBody User user) {
		userService.createUser(user);
		return user;
	}
	
	@GetMapping("/user")
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("/user/{user_id}")
	public User findById(@PathVariable int user_id)
	{
		return userService.getUserById(user_id);
	}

}
