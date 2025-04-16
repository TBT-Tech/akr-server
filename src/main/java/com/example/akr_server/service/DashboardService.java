package com.example.akr_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.akr_server.pojo.AccountStatement;

@Service
public class DashboardService {
	
	@Autowired
	AccountStatementService accountStatementService;
	
	public Double getTotalMoneyInflow() {
		List<AccountStatement> allAccountStatementByCompanyType = accountStatementService.getAllAccountStatementByCompanyType("Own");
		return allAccountStatementByCompanyType.stream().reduce(0D,(subTotal,accountStatment)->subTotal+ (double)(accountStatment.getCredit()),Double::sum);
	}
	public Double getTotalMoneyOutflow() {
		List<AccountStatement> allAccountStatementByCompanyType = accountStatementService.getAllAccountStatementByCompanyType("Own");
		return allAccountStatementByCompanyType.stream().reduce(0D,(subTotal,accountStatment)->subTotal+ (double)(accountStatment.getDebit()),Double::sum);
	}
	public Double getOwnAccountTotalBalance() {
		List<AccountStatement> allAccountStatementByCompanyType = accountStatementService.getAllAccountStatementByCompanyType("Own");
		return allAccountStatementByCompanyType.stream().reduce(0D,(subTotal,accountStatment)->subTotal+ (double)(accountStatment.getBalance()),Double::sum);
	}
	public Double getTotalBuyerBilledAmount() {
		List<AccountStatement> allAccountStatementByCompanyType = accountStatementService.getAllAccountStatementByCompanyType("Buyer");
		return allAccountStatementByCompanyType.stream().reduce(0D,(subTotal,accountStatment)->subTotal+ (double)(accountStatment.getCredit()),Double::sum);
	}
	public Double getTotalSupplierBilledAmount() {
		List<AccountStatement> allAccountStatementByCompanyType = accountStatementService.getAllAccountStatementByCompanyType("Supplier");
		return allAccountStatementByCompanyType.stream().reduce(0D,(subTotal,accountStatment)->subTotal+ (double)(accountStatment.getCredit()),Double::sum);
	}

}
