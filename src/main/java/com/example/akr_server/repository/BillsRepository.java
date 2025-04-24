package com.example.akr_server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.akr_server.pojo.Bill;

public interface BillsRepository extends MongoRepository<Bill, String>{
	

}
