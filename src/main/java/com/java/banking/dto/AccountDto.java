package com.java.banking.dto;

import lombok.Data;

@Data
public class AccountDto {
	
	private Long id;
	private String account_holder;
	private double balnce;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount_holder() {
		return account_holder;
	}
	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}
	public double getBalnce() {
		return balnce;
	}
	public void setBalnce(double balnce) {
		this.balnce = balnce;
	}
	public AccountDto(Long id, String account_holder, double balnce) {
		super();
		this.id = id;
		this.account_holder = account_holder;
		this.balnce = balnce;
	}
	

}
