package com.example.akr_server.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "Company")
@Data
public class Company {
	
	@Id
	@JsonProperty("Company ID")
	private String companyId;
	
	@JsonProperty(value="Entry Date", required=true)
	private Date entryDate;
	
	@JsonProperty(value="Company Name", required = true)
	private String companyName;
	
	@JsonProperty(value="Company Type", required = true)
	private String companyType;
	
	@JsonProperty(value="Cash Transfer", required = true)
	private Boolean isCashTransfer;
	
	@JsonProperty(value="Bank Transfer", required = true)
	private Boolean isBankTransfer;
	
	private Boolean isActive = true;
	
	@JsonProperty(value="Bank Accounts", required = true)
//	@ReadOnlyProperty
//    @DocumentReference(lookup="{'company':?#{#self._id} }")
	@DBRef
	private List<Account> bankAccounts;
	
	@JsonProperty(value="Company Location", required = true)
	private String companyLocation;
	
	@JsonProperty(value="Email", required = true)
	private String email;
	
	@JsonProperty(value="Phone Number", required = true)
	private String phoneNumber;
	
	@JsonProperty(value="GST Number", required = false)
	private String gstNumber;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(String companyId, Date entryDate, String companyName, String companyType, Boolean isCashTransfer,
			Boolean isBankTransfer, List<Account> bankAccounts, String companyLocation, String email,
			String phoneNumber, String gstNumber) {
		super();
		this.companyId = companyId;
		this.entryDate = entryDate;
		this.companyName = companyName;
		this.companyType = companyType;
		this.isCashTransfer = isCashTransfer;
		this.isBankTransfer = isBankTransfer;
		this.bankAccounts = bankAccounts;
		this.companyLocation = companyLocation;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gstNumber = gstNumber;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public Boolean getIsCashTransfer() {
		return isCashTransfer;
	}

	public void setIsCashTransfer(Boolean isCashTransfer) {
		this.isCashTransfer = isCashTransfer;
	}

	public Boolean getIsBankTransfer() {
		return isBankTransfer;
	}

	public void setIsBankTransfer(Boolean isBankTransfer) {
		this.isBankTransfer = isBankTransfer;
	}

	public List<Account> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<Account> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	
	
	
}
