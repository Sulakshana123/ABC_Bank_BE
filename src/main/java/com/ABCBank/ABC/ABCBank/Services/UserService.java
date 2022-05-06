package com.ABCBank.ABC.ABCBank.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ABCBank.ABC.ABCBank.model.User;
import com.ABCBank.ABC.ABCBank.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public void createUser(User user)
	{
		userRepository.save(user);
	}
	
	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}
	
	public User getUserById(int user_id)
	{
		return userRepository.findById(user_id).get();
	}
	
	public void deleteUserById(int user_id)
	{
		userRepository.deleteById(user_id);
	}

	
}
