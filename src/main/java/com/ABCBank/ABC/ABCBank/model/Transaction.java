package com.ABCBank.ABC.ABCBank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getWithdraw_amount() {
		return withdraw_amount;
	}
	public void setWithdraw_amount(String withdraw_amount) {
		this.withdraw_amount = withdraw_amount;
	}
	public String getDeposit_amount() {
		return deposit_amount;
	}
	public void setDeposit_amount(String deposit_amount) {
		this.deposit_amount = deposit_amount;
	}
	
	
	
	public Transaction(int transaction_id, String withdraw_amount, String deposit_amount) {
		super();
		this.transaction_id = transaction_id;
		this.withdraw_amount = withdraw_amount;
		this.deposit_amount = deposit_amount;
	}
	
	public Transaction() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction_id;
	private String withdraw_amount;
	private String deposit_amount;
	

}
