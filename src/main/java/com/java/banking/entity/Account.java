package com.java.banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="Acount Holder")
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="accountholderName")
	private String account_holder;
	private double balance;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccount_holder() {
		return account_holder;
	}
	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}
	public Account(Long id, String account_holder, double balance) {
		super();
		this.id = id;
		this.account_holder = account_holder;
		this.balance = balance;
	}
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", account_holder=" + account_holder + ", balance=" + balance + "]";
	}
	

}
