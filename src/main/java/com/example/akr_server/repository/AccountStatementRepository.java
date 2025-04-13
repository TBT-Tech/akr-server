package com.example.akr_server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.akr_server.pojo.AccountStatement;

public interface AccountStatementRepository extends MongoRepository<AccountStatement, String>  {
	
//	@Query("{'Account ID' :{'$ref' : 'Account ID' , '$id' : ?0}}")
	public List<AccountStatement> findAllByAccountId(String accountId);
	
//	Both Not Working
//	@Query(value = "{ '`Account ID`.`Company Type`' : ?0 }")
//	@Query(value = "{'Account ID' :{'$ref' : 'companyType' , '$id' : '?0'}}")
//	List<AccountStatement> findAllByCompanyType(String companyType);

}
