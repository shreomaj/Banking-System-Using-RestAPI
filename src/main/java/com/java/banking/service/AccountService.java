package com.java.banking.service;

import java.util.List;

import com.java.banking.dto.AccountDto;
import com.java.banking.entity.Account;

public interface AccountService {
	AccountDto createAccount(AccountDto accountDto);
	//List<Account> getAll();
	AccountDto getAccountById(Long id);
	AccountDto deposit(Long id, double amount);
	AccountDto withDraw(Long id, double amount);
	List<AccountDto> getAllAccount();
	void deleteAccount(Long id);
	
}
