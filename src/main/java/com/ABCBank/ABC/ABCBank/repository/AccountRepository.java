package com.ABCBank.ABC.ABCBank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ABCBank.ABC.ABCBank.model.Account;




public interface AccountRepository extends JpaRepository<Account, Integer>{
//	Optional<Account> findByAccount_Id(int account_Id);
	
	//Optional<Account> deleteByAccountId(int account_Id);

}

