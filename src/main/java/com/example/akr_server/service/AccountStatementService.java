package com.example.akr_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.akr_server.pojo.AccountStatement;
import com.example.akr_server.repository.AccountStatementRepository;

@Service
public class AccountStatementService {
	
	@Autowired
	AccountStatementRepository accountStatementRepository;

	public List<AccountStatement> getAllAccountStatement(){
		return accountStatementRepository.findAll();
	}
	public List<AccountStatement> getAllAccountStatementByAccountID(String accountID){
		return accountStatementRepository.findAllByAccountId(accountID);
	}
}
