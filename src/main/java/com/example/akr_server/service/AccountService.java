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
	
	public List<Account> getAllActiveAccounts() {
		return accountRepository.findByIsActive(true);
	}
	
	public List<Account> getAccountsByAccountType(String companyType){
		return accountRepository.findByCompanyType(companyType,true);
	}
	
	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}

	public Long getAllOwnAccountTotalBalance() {
		return accountRepository.findByCompanyType("Own", true).stream().map(Account::getBalance).reduce(0L, Long::sum);
	}
}
