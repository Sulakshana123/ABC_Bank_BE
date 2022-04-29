package com.ABCBank.ABC.ABCBank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ABCBank.ABC.ABCBank.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	//Optional<User> findByUser(int user_id);
	
	//Optional<User> deleteUser(int user_id);

}
