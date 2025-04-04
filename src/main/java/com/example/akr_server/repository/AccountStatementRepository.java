package com.example.akr_server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.akr_server.pojo.AccountStatement;

public interface AccountStatementRepository extends MongoRepository<AccountStatement, String>  {
	
//	@Query("{'Account ID' :{'$ref' : 'Account ID' , '$id' : ?0}}")
	public List<AccountStatement> findAllByAccountId(String accountId);

}
