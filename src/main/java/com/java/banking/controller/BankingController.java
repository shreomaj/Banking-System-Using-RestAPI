package com.java.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.banking.dto.AccountDto;
import com.java.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class BankingController {
	private AccountService accountService;

	public BankingController(AccountService accountService) {
		this.accountService = accountService;
	}
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
	{
		AccountDto accountdto=accountService.getAccountById(id);
		return ResponseEntity.ok(accountdto);
	}
	//Deposite REst API
	@PutMapping("/{id}/{deposit}")
	public ResponseEntity<AccountDto> deposite(@PathVariable Long id, @RequestBody Map<String, Double> request){
		AccountDto accountDto=accountService.deposit(id, request.get("amount"));
		return ResponseEntity.ok(accountDto);
	}
	//withdraw REst API
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
	AccountDto accountDto=accountService.withDraw(id, request.get("amount"));
	return ResponseEntity.ok(accountDto);
	}
	//Get all acount
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAccounts(){
		List<AccountDto> accounts=accountService.getAllAccount();
		return ResponseEntity.ok(accounts);
}
	//Delete Account
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteAccount(@PathVariable Long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account is Deleted Succesfully");
		
	}

}
