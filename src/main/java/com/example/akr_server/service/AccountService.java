package com.example.akr_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.akr_server.pojo.Account;
import com.example.akr_server.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}
	
	public List<Account> getAccountsByAccountType(String companyType){
		return accountRepository.findByAccountType(companyType);
	}

}
