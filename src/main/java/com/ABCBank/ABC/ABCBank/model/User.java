package com.ABCBank.ABC.ABCBank.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "user")
public class User {
	

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String first_name;
	private String last_name;
	private String email;
	private String address;
	private String password;
	
	
	

	@OneToMany(mappedBy = "owner")
	@JsonIgnoreProperties("owner")
	private List<Account> account;




	public User(int user_id, String first_name, String last_name, String email, String address, String password,
			List<Account> account) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.address = address;
		this.password = password;
		this.account = account;
	}




	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", address=" + address + ", password=" + password + ", account=" + account + "]";
	}




	public int getUser_id() {
		return user_id;
	}




	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}




	public String getFirst_name() {
		return first_name;
	}




	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}




	public String getLast_name() {
		return last_name;
	}




	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public List<Account> getAccount() {
		return account;
	}




	public void setAccount(List<Account> account) {
		this.account = account;
	}



	
	
	
	
	

}
