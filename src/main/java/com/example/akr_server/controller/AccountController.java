package com.example.akr_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.akr_server.pojo.Account;
import com.example.akr_server.service.AccountService;

@RestController
@RequestMapping("/akr/api")
@CrossOrigin(origins = {"http://localhost:5173/","https://akr-client.web.app"})
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/fetchAllAccount")
	public List<Account> getAllAccount(){
		return accountService.getAllAccounts();
	}
	@GetMapping("/fetchAllAccountByCompanyType/{companyType}")
	public List<Account> getAllAccount(@PathVariable String companyType){
		return accountService.getAccountsByAccountType(companyType);
	}
}
