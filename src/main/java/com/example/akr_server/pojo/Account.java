package com.example.akr_server.pojo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "Account")
public class Account {
	
	@Id
	@JsonProperty("Account ID")
	private String accountID;
	
	@JsonProperty(value="Account Name", required=true)
	private String accountName;
	
	@JsonProperty(value="Account Number", required = true)
	private String accountNumber;
	
	//Should we rename this as COMPANY TYPE?
	@JsonProperty(value="Company Type", required = true)
	private String companyType;
	
	@JsonProperty(value="Balance")
	private Long balance= 0L;
	
	private Boolean isActive=true;
	
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


	public Account  creditBillAmount(Long amount) {
		this.balance+=amount;
		return this;
	}
	public Account  debitBillAmount(Long amount) {
		this.balance-=amount;
		return this;
	}

	
	
}
