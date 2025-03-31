package com.example.akr_server.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Account")
public class Account {
	
	@Id
	@JsonProperty("Account ID")
	private String accountID;
	
	@JsonProperty(value="Account Name", required=true)
	private String accountName;
	
	@JsonProperty(value="Account Number", required = true)
	private String accountNumber;
	
//	@DocumentReference
//	@JsonProperty(value = "company")
//	@ReadOnlyProperty
//	private Company company;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String accountID, String accountName, String accountNumber, Company company) {
		super();
		this.accountID = accountID;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
//		this.company = company;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

//	public Company getCompany() {
//		return company;
//	}
//
//	public void setCompany(Company company) {
//		this.company = company;
//	}
//	
	
	
}
