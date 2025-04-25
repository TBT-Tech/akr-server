package com.example.akr_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.akr_server.pojo.Bill;
import com.example.akr_server.pojo.TransactionDTO;
import com.example.akr_server.repository.AccountRepository;
import com.example.akr_server.repository.AccountStatementRepository;
import com.example.akr_server.repository.BillsRepository;
import com.example.akr_server.repository.CompanyRepository;
import com.example.akr_server.repository.TransactionRepository;

@Service
public class BillsService {
	
	@Autowired
	private BillsRepository billsRepository;
	
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private AccountRepository accountRepository;
	
	public List<Bill> getAllBills(){
		return billsRepository.findAll();
	}
	
	public Bill addBuyerBill(Bill buyerBill,String buyerAccountId) {
		buyerBill.setBillType("Buyer");
		TransactionDTO transactionDTO = new TransactionDTO(
				buyerBill.getEntryDate(),
				true,
				Long.valueOf(buyerBill.getBillAmount()),
				false,
				0L,
				null,
				accountRepository.findById(buyerAccountId).orElse(null),
				accountRepository.findByCompanyType("Own", true).getFirst(),
				Long.valueOf(buyerBill.getAdvanceAmount()),
				buyerBill.getRemarks()
				);
		transactionService.addTransaction(transactionDTO);
		return billsRepository.save(buyerBill);
	}
	
	public Bill addSupplierBill(Bill supplierBill, String supplierAccountId) {
		supplierBill.setBillType("Supplier");
		TransactionDTO transactionDTO = new TransactionDTO(
				supplierBill.getEntryDate(),
				false,
				0L,
				true,
				Long.valueOf(supplierBill.getBillAmount()),
				null,
				accountRepository.findByCompanyType("Own", true).getFirst(),
				accountRepository.findById(supplierAccountId).orElse(null),
				Long.valueOf(supplierBill.getAdvanceAmount()),
				supplierBill.getRemarks()
				);
		transactionService.addTransaction(transactionDTO);
		return billsRepository.save(supplierBill);
	}

}
