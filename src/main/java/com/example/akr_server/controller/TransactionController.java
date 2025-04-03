package com.example.akr_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.akr_server.pojo.Transaction;
import com.example.akr_server.pojo.TransactionDTO;
import com.example.akr_server.service.TransactionService;

@RestController
@RequestMapping("/akr/api")
@CrossOrigin(origins = {"http://localhost:5173/","https://akr-client.web.app"})
public class TransactionController {
@Autowired
private TransactionService transactionService;


@GetMapping("/getAllTransaction")
public List<Transaction> getAllTransaction() {
	return transactionService.getAllTransaction();
}

@PostMapping("/addTransaction")
public Transaction addTransaction(@RequestBody TransactionDTO transaction) {
	return transactionService.addTransaction(transaction);
}
	
}
