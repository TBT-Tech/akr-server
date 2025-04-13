package com.example.akr_server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.akr_server.pojo.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
	
	public List<Account> findByCompanyType(String companyType);
	
	public List<Account> findByIsActive(Boolean isActive);

}
