package com.example.akr_server.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.akr_server.pojo.Account;
import com.example.akr_server.pojo.AccountStatement;
import com.example.akr_server.pojo.Transaction;
import com.example.akr_server.pojo.TransactionDTO;
import com.example.akr_server.repository.AccountRepository;
import com.example.akr_server.repository.AccountStatementRepository;
import com.example.akr_server.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountStatementRepository accountStatementRepository;
	
	private static String BUYER="BUYER";
	private static String SUPPLIER="SUPPLIER";
	
	public List<Transaction> getAllTransaction() {
		return transactionRepository.findAll();
		
	}
	@Transactional
	public Transaction addTransaction(TransactionDTO transactionDTO) {
		
		Transaction transaction=new Transaction();
		BeanUtils.copyProperties(transactionDTO, transaction);
		List<Account> accountsDetails = accountRepository.findAllById(List.of(transactionDTO.getSenderAccount().getAccountID(),transactionDTO.getReceiverAccount().getAccountID()));
		Map<String, Account> accountMap = accountsDetails.stream()
		        .collect(Collectors.toMap(Account::getAccountID, Function.identity()));
		accountMap.values().forEach(s->log.info("Accounts fetched {}",s)); 
		
		
		if(transactionDTO.getNewbuyerBill()) {
			accountMap.get(transactionDTO.getSenderAccount().getAccountID()).creditBillAmount(transactionDTO.getBuyerbillAmount()).debitBillAmount(transactionDTO.getAmountPaid());
			
		} else {
			accountMap.get(transactionDTO.getSenderAccount().getAccountID()).debitBillAmount(transactionDTO.getAmountPaid());
		}
		
		if(accountMap.get(transactionDTO.getReceiverAccount().getAccountID()).getCompanyType().equalsIgnoreCase(SUPPLIER)) {
		
		if(transactionDTO.getNewSupplierBill()) {
			accountMap.get(transactionDTO.getReceiverAccount().getAccountID()).creditBillAmount(transactionDTO.getSupplierbillAmount()).debitBillAmount(transactionDTO.getAmountPaid());
			
		} else {
			accountMap.get(transactionDTO.getReceiverAccount().getAccountID()).debitBillAmount(transactionDTO.getAmountPaid());
		}
		} else {
			accountMap.get(transactionDTO.getReceiverAccount().getAccountID()).creditBillAmount(transactionDTO.getAmountPaid());
		}
		accountMap.values().forEach(s->log.info("Accounts after transaction: {}",s)); 
		
		accountRepository.saveAll(accountMap.values());
		transaction=transactionRepository.save(transaction);
		
		log.info("Transaction added: {}",transaction);
		AccountStatement senderStatement=new AccountStatement();
		senderStatement.setEntryDate(transactionDTO.getEntryDate());
		senderStatement.setAccountId(accountMap.get(transactionDTO.getSenderAccount().getAccountID()));
		senderStatement.setCredit(transactionDTO.getBuyerbillAmount()!=null?transactionDTO.getBuyerbillAmount():0);
		senderStatement.setDebit(transactionDTO.getAmountPaid());
		senderStatement.setBalance(accountMap.get(transactionDTO.getSenderAccount().getAccountID()).getBalance());
		senderStatement.setTransactionId(transaction);
		
		AccountStatement receiverStatement=new AccountStatement();
		receiverStatement.setEntryDate(transactionDTO.getEntryDate());
		receiverStatement.setAccountId(accountMap.get(transactionDTO.getReceiverAccount().getAccountID()));
		
		if(accountMap.get(transactionDTO.getReceiverAccount().getAccountID()).getCompanyType().equalsIgnoreCase(SUPPLIER)) {
			receiverStatement.setCredit(transactionDTO.getSupplierbillAmount() != null 
			        ? transactionDTO.getSupplierbillAmount() 
			                : 0);
			receiverStatement.setDebit(transactionDTO.getAmountPaid());
		}else {
			receiverStatement.setCredit(transactionDTO.getAmountPaid());
		}
		receiverStatement.setBalance(accountMap.get(transactionDTO.getReceiverAccount().getAccountID()).getBalance());
		receiverStatement.setTransactionId(transaction);
		
		List<AccountStatement> accountstatements = accountStatementRepository.saveAll(List.of(senderStatement, receiverStatement));
		accountstatements.stream().forEach(a->log.info("Account Statements added {}",a));
		
		return transaction;
		
	}
}
