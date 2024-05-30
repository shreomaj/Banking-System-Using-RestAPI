package com.java.banking.mapper;

import com.java.banking.dto.AccountDto;
import com.java.banking.entity.Account;

public class AccountMapper {
	public static Account mapToAccount(AccountDto accountDto) {
		Account account=new Account(
				accountDto.getId(),
				accountDto.getAccount_holder(),
				accountDto.getBalnce()
				);
		return account;
		
	}
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto=new AccountDto(
				account.getId(),
				account.getAccount_holder(),
				account.getBalance()
				);
		return accountDto;
	}

}
