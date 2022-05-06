package com.ABCBank.ABC.ABCBank.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ABCBank.ABC.ABCBank.Services.AccountService;
import com.ABCBank.ABC.ABCBank.Services.PdfExporterService;
import com.ABCBank.ABC.ABCBank.Services.TransactionService;
import com.ABCBank.ABC.ABCBank.model.Transaction;

import com.lowagie.text.DocumentException;
import com.ABCBank.ABC.ABCBank.model.Account;




@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/createTransaction")
	public Transaction createTransaction(@RequestBody Transaction transaction)
	{
		
		transactionService.createTransaction(transaction);
		return transaction;
	}
	
//	@GetMapping("/transaction")
//	public List<Transaction> getAllTransaction()
//	{
//		return transactionService.getAllTransaction();
//	}
	
	@GetMapping("/transaction/{transaction_id}")
	public Transaction findById(@PathVariable int transaction_id)
	{
		return transactionService.getTransactionById(transaction_id);
	}
	
	@DeleteMapping("/Transactiondelete/{transaction_id}")
	public String deleteById(@PathVariable int transaction_id)
	{
		transactionService.deleteTransactionById(transaction_id);
		return "Success Transaction Delete";
	}
	
	@PostMapping("/d")
	public void depositeMoney(@RequestBody Transaction transaction) {
		System.out.println(transaction.toString());
		int account_Id = transaction.getAccount_Id();
		System.out.println("account_Id "+account_Id);
		System.out.println("full transaction record: "+transaction.toString());
//		System.out.println("id at controller: " + transaction.getAccNumber());
		float amount = transaction.getAmount();
//		System.out.println("before fetching account");
		Account depositeAccountID = accountService.getAccountById(account_Id);
//		System.out.println("reached this point");
		float newBalace = (accountService.getAccountById(account_Id).getAccount_balance()   + (float) amount);
		
		
		accountService.incremetValue(depositeAccountID, newBalace);
		transactionService.createTransaction(transaction);
		
	}
	
	@PostMapping("/withdraw")
	public void withdrawMoney(@RequestBody Transaction transaction) {
		int account_Id = transaction.getAccount_Id();
//		System.out.println(transaction.toString());
//		System.out.println("id at controller: " + transaction.getAccNumber());
		float amount = transaction.getAmount();
//		System.out.println("before fetching account");
		Account depositeAccountID = accountService.getAccountById(account_Id);
//		System.out.println("reached this point");
		float newBalace = (accountService.getAccountById(account_Id).getAccount_balance() - (float) amount);
		
		accountService.incremetValue(depositeAccountID, newBalace);
		transactionService.createTransaction(transaction);
	}
	
	@PostMapping("/transaction")
	public String transaction(@RequestBody Transaction transaction) {
		float amount = transaction.getAmount();
		
		int account_Id = transaction.getAccount_Id();
		Account sourceAccount = accountService.getAccountById(account_Id);
		float newSourceBalace = (accountService.getAccountById(account_Id).getAccount_balance() - (float) amount);
		accountService.incremetValue(sourceAccount, newSourceBalace);
		
		int destinationAccId = transaction.getDestinationAccId();
		Account destinationAcc = accountService.getAccountById(destinationAccId);
		float newDestinationBalace = (accountService.getAccountById(destinationAccId).getAccount_balance() + (float) amount);
		accountService.incremetValue(destinationAcc, newDestinationBalace);

		
		
		transactionService.createTransaction(transaction);
		return "Successfully tranfered";
	}
	
	@GetMapping("/alltransactions")
	public List<Transaction> getAllTransactions(){
		return transactionService.getAllTransaction();
		
	}
	
	@GetMapping("/exporttransaction/{id}")
	public void createPdf(HttpServletResponse response, @PathVariable int id) throws DocumentException, IOException {
		Account acc = accountService.getAccountById(id);
		//List<Transaction> tansactionList = transactionService.getAllTransaction();
		response.setContentType("application/pdf");
		PdfExporterService pdfService = new PdfExporterService(acc, accountService);
		pdfService.createPdf(response);
	}
	
	
}
