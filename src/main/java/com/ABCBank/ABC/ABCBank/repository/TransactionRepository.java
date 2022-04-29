package com.ABCBank.ABC.ABCBank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ABCBank.ABC.ABCBank.model.Transaction;



public interface TransactionRepository  extends JpaRepository<Transaction, Integer>{
	//Optional<Transaction> findById(int transaction_id);
	
	//Optional<Transaction> deleteById(int transaction_id);

}
