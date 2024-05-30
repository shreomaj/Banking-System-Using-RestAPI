package com.java.banking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.java.banking.dto.AccountDto;
import com.java.banking.entity.Account;
import com.java.banking.mapper.AccountMapper;
import com.java.banking.repository.AccountRepository;
import com.java.banking.service.AccountService;

@Service
public class BankingServiceImpl implements AccountService{
	
	private AccountRepository accountRepository;
	

	public BankingServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}


	@Override
	public AccountDto createAccount(AccountDto accountDto) {
				
		Account account= AccountMapper.mapToAccount(accountDto);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
		
	
	}


	
	public AccountDto getAccountById(Long id) {
		
		Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Doesn't Exist"));
	    return AccountMapper.mapToAccountDto(account);
	}


	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Doesn't Exist"));
		double total=account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}


	@Override
	public AccountDto withDraw(Long id, double amount) {
		Account account=accountRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Account Doesn't Exist"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("InSufficient Amount");
		}
		double total=account.getBalance()-amount;
		account.setBalance(total);
		Account saveAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(saveAccount);
		
	}


	@Override
	public List<AccountDto> getAllAccount() {
		List<Account> accounts=accountRepository.findAll();
		return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		
		
	}


	@Override
	public void deleteAccount(Long id) {
		
		Account account=accountRepository.
				findById(id).
				orElseThrow(()->new RuntimeException("Account Doesn't Exist"));
		accountRepository.deleteById(id);
		
	}




	

}
