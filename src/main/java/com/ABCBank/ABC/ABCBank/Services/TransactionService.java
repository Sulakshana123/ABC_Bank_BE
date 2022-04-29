package com.ABCBank.ABC.ABCBank.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ABCBank.ABC.ABCBank.model.Transaction;
import com.ABCBank.ABC.ABCBank.repository.TransactionRepository;


@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	public void createTransaction(Transaction transaction)
	{
		transactionRepository.save(transaction);
	}
	
	public List<Transaction> getAllTransaction()
	{
		return transactionRepository.findAll();
	}
	
	public Transaction getTransactionById(int transaction_id)
	{
		return transactionRepository.findById(transaction_id).get();
	}
	
	public void deleteTransactionById(int transaction_id)
	{
		transactionRepository.deleteById(transaction_id);
	}
}
