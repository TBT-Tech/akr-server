package com.example.akr_server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import com.example.akr_server.bean.PartyDetail;

//@Repository
public interface PartyDetailRepository extends MongoRepository<PartyDetail, String> {
	public long count();

	@Query("{partyName:'?0'}")
	PartyDetail findItemByName(String partyName);
	
	@Query(value="{partyLocation:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	List<PartyDetail> findAll(String partyLocation);
}
