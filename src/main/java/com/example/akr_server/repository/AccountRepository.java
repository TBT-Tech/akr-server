package com.example.akr_server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.akr_server.pojo.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
	
	@Query("{ companyType:'?0', isActive: ?1 }")
	public List<Account> findByCompanyType(String companyType, Boolean isActive);
	
	@Query("{ isActive: ?0 }")
	public List<Account> findByIsActive(Boolean isActive);

}
