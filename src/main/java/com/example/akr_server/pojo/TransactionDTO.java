package com.example.akr_server.pojo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class TransactionDTO {
	@JsonProperty("Entry Date")
	private Date entryDate;
	
	@JsonProperty("New Buyer Bill")
	private Boolean newbuyerBill;
	@JsonProperty("Buyer Bill Amount")
	private Long buyerbillAmount;
	
	@JsonProperty("New Supplier Bill")
	private Boolean newSupplierBill;
	@JsonProperty("Supplier Bill Amount")
	private Long supplierbillAmount;
	@JsonProperty("Transaction ID")
	private String transactionId;
	
	@JsonProperty("Sender Account")
	private Account senderAccount;
	
	@JsonProperty("Receiver Account")
	private Account receiverAccount;
	
	@JsonProperty("Amount Paid")
	private Long amountPaid;
	
	@JsonProperty("remarks")
	private String remarks;

}
