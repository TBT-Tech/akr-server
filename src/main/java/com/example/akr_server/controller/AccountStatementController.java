package com.example.akr_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.akr_server.pojo.AccountStatement;
import com.example.akr_server.service.AccountStatementService;

@RestController
@RequestMapping("/akr/api")
@CrossOrigin(origins = {"http://localhost:5173/","https://akr-client.web.app"})
public class AccountStatementController {
	
	@Autowired
	AccountStatementService accountStatementService;
	
	@GetMapping("/fetchAllAccountStatement")
	public List<AccountStatement> getAllAccountStatement() {
		return accountStatementService.getAllAccountStatement();
	}
	@GetMapping("/fetchAllAccountStatementByCompanyType/{companyType}")
	public List<AccountStatement> getAllAccountStatementByCompanyType(@PathVariable String companyType) {
		return accountStatementService.getAllAccountStatementByCompanyType(companyType);
	}
	
	@GetMapping("/fetchAllAccountStatementByAccountID/{accountID}")
	public List<AccountStatement> getAllAccountStatementByAccountID(@PathVariable String accountID){
		return accountStatementService.getAllAccountStatementByAccountID(accountID);
	}

}
