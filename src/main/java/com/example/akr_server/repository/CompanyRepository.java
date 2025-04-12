package com.example.akr_server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import com.example.akr_server.pojo.Company;

//@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {
	public long count();

	@Query("{partyName:'?0'}")
	Company findItemByName(String partyName);
	
	@Query(value="{partyLocation:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	List<Company> findAll(String partyLocation);
	
	@Query("{ isActive: ?0 }")
	List<Company> findByIsActive(Boolean isActive);


}
