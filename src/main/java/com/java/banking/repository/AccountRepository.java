package com.java.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.banking.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	

}
