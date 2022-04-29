package com.ABCBank.ABC.ABCBank.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ABCBank.ABC.ABCBank.Services.TransactionService;
import com.ABCBank.ABC.ABCBank.model.Transaction;

@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/createTransaction")
	public Transaction createTransaction(@RequestBody Transaction transaction)
	{
		
		transactionService.createTransaction(transaction);
		return transaction;
	}
	
	@GetMapping("/transaction")
	public List<Transaction> getAllTransaction()
	{
		return transactionService.getAllTransaction();
	}
	
	@GetMapping("/transaction/{transaction_id}")
	public Transaction findById(@PathVariable int transaction_id)
	{
		return transactionService.getTransactionById(transaction_id);
	}
	
	@GetMapping("/Transactiondelete/{transaction_id}")
	public String deleteById(@PathVariable int transaction_id)
	{
		transactionService.deleteTransactionById(transaction_id);
		return "Success Transaction Delete";
	}

}
