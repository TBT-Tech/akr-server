package com.example.akr_server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.example.akr_server.pojo.AccountStatement;

public interface AccountStatementRepository extends MongoRepository<AccountStatement, String>  {

}
