package com.ABCBank.ABC.ABCBank.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ABCBank.ABC.ABCBank.model.Account;
import com.ABCBank.ABC.ABCBank.repository.AccountRepository;
import java.util.List;



@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountrepository;

	public void createAccount(Account account)
	{
		accountrepository.save(account);
	}
	
	public List<Account> getAllAccount()
	{
		return accountrepository.findAll();
	}
	
	public Account getAccountById(int account_Id)
	{
		
		return accountrepository.findById(account_Id).get();
	}
	
	public String deleteAccountById(int account_Id) {
		accountrepository.deleteById(account_Id);
		return "Successfully delete";
	}
	
	public void incremetValue(Account account, float newbalance) {
		account.setAccount_balance(newbalance);
		accountrepository.save(account);
	}
	
	public void decremetValue(Account account, float newbalance) {
		account.setAccount_balance(newbalance);
		accountrepository.save(account);
	}

	
}
