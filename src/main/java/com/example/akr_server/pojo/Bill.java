package com.example.akr_server.pojo;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Document(collection = "Bills")
@Data
public class Bill {

	@Id
	@JsonProperty("Bill ID")
	private String billId;
	
	@JsonProperty("Entry Date")
	private Date entryDate;
	
	@JsonProperty("Bill Type")
	private String billType;
	
	@JsonProperty("Company Name")
	private String companyName;
	
	@JsonProperty("Bill Amount")
	private Long billAmount;
	
	
	@JsonProperty("Remarks")
	private String remarks;
}
