package com.example.akr_server.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;

//import jakarta.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("PartyDetail")
public class PartyDetail {
	
	@Id
	@JsonProperty("Party ID")
	public String id;
	
	@JsonProperty("Entry Date")
	public Date entryDate;
	@JsonProperty("Party Name")
	public String partyName;
	@JsonProperty("Party Location")
	public String partyLocation;
	
}
