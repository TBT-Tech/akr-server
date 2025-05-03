package com.example.akr_server.pojo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
@Document(collection = "AccountStatement")
public class AccountStatement {
	@Id
	@JsonProperty("Account Statement ID")
	private String accountStatmentID;
	
	@JsonProperty("Entry Date")
	private Date entryDate;
	
	@JsonProperty("Remarks")
	private String remarks;
	
	@JsonProperty("Transaction ID")
	@DBRef
	private Transaction transactionId;
	
	@JsonProperty("Account ID")
	@DBRef
	private Account accountId;
	@JsonProperty("Credit")
	private long credit;
	@JsonProperty("Debit")
	private long debit;
	@JsonProperty("Balance")
	private long balance;
	@JsonProperty(value="Cumulative Balance",required = false)
	@Nullable
	private Long cumulativeBalance;
	
	
	

}
