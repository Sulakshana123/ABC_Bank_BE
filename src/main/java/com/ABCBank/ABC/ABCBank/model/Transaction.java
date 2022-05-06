package com.ABCBank.ABC.ABCBank.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "transaction")
public class Transaction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction_id;
	private int account_Id;
	private float amount;
	private Timestamp dateTime;
	private String type;
	private int destinationAccId;
	
//	private transaction Owner;
//	
	
	public int getDestinationAccId() {
		return destinationAccId;
	}


	public void setDestinationAccId(int destinationAccId) {
		this.destinationAccId = destinationAccId;
	}

	
	
	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


	


	public Transaction(int transaction_id, int account_Id, float amount, Timestamp dateTime, String type,
			int destinationAccId, Account ownerAcc) {
		super();
		this.transaction_id = transaction_id;
		this.account_Id = account_Id;
		this.amount = amount;
		this.dateTime = dateTime;
		this.type = type;
		this.destinationAccId = destinationAccId;
		this.ownerAcc = ownerAcc;
	}


	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", account_Id=" + account_Id + ", amount=" + amount
				+ ", dateTime=" + dateTime + ", type=" + type + ", destinationAccId=" + destinationAccId + ", ownerAcc="
				+ ownerAcc + "]";
	}


	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getAccount_Id() {
		return account_Id;
	}
	public void setAccount_Id(int account_Id) {
		this.account_Id = account_Id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

	public Account getOwnerAcc() {
		return ownerAcc;
	}


	public void setOwnerAcc(Account ownerAcc) {
		this.ownerAcc = ownerAcc;
	}





	@ManyToOne
	@JoinColumn(name = "account_id", insertable = false, updatable = false, nullable= false, referencedColumnName = "account_id")
	@JsonIgnoreProperties("transaction")
	private Account ownerAcc;
	

	

	
	
	

}
