package com.example.akr_server.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.example.akr_server.pojo.Account;
import com.example.akr_server.pojo.Company;
import com.example.akr_server.repository.AccountRepository;
import com.example.akr_server.repository.CompanyRepository;
//import com.example.akr_server.repository.CompanyRepository;


@Service
@EnableMongoRepositories
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	public List<Company> getAllCompany(){
		
		return companyRepository.findAll();
	}
	
	public Company createCompany(Company company) {
		
		 
//				 List<Account> updatedAccounts = company.getBankAccounts()
//				 				.stream()
//				 				.map(eachAccount -> {eachAccount.setCompany(company); return eachAccount;}).collect(Collectors.toList());
//		
//				 company.setBankAccounts(updatedAccounts);
		List<Account> savedAccounts = accountRepository.saveAll(company.getBankAccounts());
		company.setBankAccounts(savedAccounts);
		System.out.println(savedAccounts);
		return companyRepository.save(company);
	}

	public void deleteCompanyById(String companyId) {
		
		try {
			companyRepository.findById(companyId).map(existingCompany -> {
				accountRepository.deleteAll(existingCompany.getBankAccounts());
		        companyRepository.delete(existingCompany);
		        return existingCompany;
		    }).orElse(null);
			companyRepository.deleteById(companyId);
		}catch (Exception e) {
			System.out.println("Error:"+e.getMessage());
		}
		
	}
}

