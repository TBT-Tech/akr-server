package com.example.akr_server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.akr_server.pojo.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String>  {

}
