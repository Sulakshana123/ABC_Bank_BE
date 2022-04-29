package com.ABCBank.ABC.ABCBank.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ABCBank.ABC.ABCBank.Services.AccountService;
import com.ABCBank.ABC.ABCBank.model.Account;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/createdAccount")
	public Account createAccount(@RequestBody Account account)
	{
		
		accountService.createAccount(account);
		return account;
	}
	
	@GetMapping("/account")
	public List<Account> getAllAccount()
	{
		return accountService.getAllAccount();
	}
	
	@GetMapping("/account/{account_Id}")
	public Account findById(@PathVariable int account_Id)
	{
		return accountService.getAccountById(account_Id);
	}
	
	/*
	@GetMapping("/accountdelete/{account_Id}")
	public String deleteById(@PathVariable int account_Id)
	{
		accountService.deleteAccountById(account_Id);
		return "Success Account Delete";
	}
*/
}
