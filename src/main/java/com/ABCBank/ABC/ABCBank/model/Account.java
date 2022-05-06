package com.ABCBank.ABC.ABCBank.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "account")
public class Account {
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false, nullable= false, referencedColumnName = "user_id")
	@JsonIgnoreProperties("account")
	private User owner;
	
	@OneToMany(mappedBy = "ownerAcc")
	@JsonIgnoreProperties("ownerAcc")
	private List<Transaction> transaction;
	
	public List<Transaction> getTransaction() {
		return transaction;
	}


	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int account_Id;
	private String account_name;
	private float account_balance;
	//private float newAccountBalance;
	private String COD;
	private int user_id;
	
	
	
	
	
	
	
	public Account(List<Transaction> transaction, User owner, int account_Id, String account_name,
			float account_balance, String cOD, int user_id) {
		super();
		this.transaction = transaction;
		this.owner = owner;
		this.account_Id = account_Id;
		this.account_name = account_name;
		this.account_balance = account_balance;
		COD = cOD;
		this.user_id = user_id;
	}


	public Account() {
		
	}

	
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCOD() {
		return COD;
	}
	public void setCOD(String cOD) {
		COD = cOD;
	}
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

	
	public float getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(float account_balance) {
		this.account_balance = account_balance;
	}
	

//	@Override
//	public String toString() {
//		return "Account [owner=" + owner + ", account_Id=" + account_Id + ", account_name=" + account_name
//				+ ", account_balance=" + account_balance + ", COD=" + COD + ", user_id=" + user_id + ", transaction="
//				+ transaction + "]";
//	}
	
	


	


}
