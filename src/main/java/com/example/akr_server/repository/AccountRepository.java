package com.example.akr_server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.akr_server.pojo.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

}
