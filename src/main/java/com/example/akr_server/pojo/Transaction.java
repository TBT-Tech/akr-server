package com.example.akr_server.pojo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
@Document(collection = "Transaction")
public class Transaction {
	@Id
	@JsonProperty("Transaction ID")
	private String transactionId;
	
	@JsonProperty("Entry Date")
	private Date entryDate;
	
	@JsonProperty("Sender Account")
	@DBRef
	private Account senderAccount;
	
	@JsonProperty("Receiver Account")
	@DBRef
	private Account receiverAccount;
	
	@JsonProperty("Amount Paid")
	private Long amountPaid;
	
	@JsonProperty("remarks")
	private String remarks;

}
