package com.ABCBank.ABC.ABCBank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	public int getAccount_Id() {
		return account_Id;
	}
	public void setAccount_Id(int account_Id) {
		this.account_Id = account_Id;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(String account_balance) {
		this.account_balance = account_balance;
	}
	
	
	public Account(int account_Id, String account_name, String account_balance) {
		super();
		this.account_Id = account_Id;
		this.account_name = account_name;
		this.account_balance = account_balance;
	}
	public Account() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int account_Id;
	@Override
	public String toString() {
		return "Account [account_Id=" + account_Id + ", account_name=" + account_name + ", account_balance="
				+ account_balance + ", getAccount_Id()=" + getAccount_Id() + ", getAccount_name()=" + getAccount_name()
				+ ", getAccount_balance()=" + getAccount_balance() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	private String account_name;
	private String account_balance;


}
