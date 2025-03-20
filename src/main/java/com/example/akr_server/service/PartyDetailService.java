package com.example.akr_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.example.akr_server.bean.PartyDetail;
import com.example.akr_server.repository.PartyDetailRepository;
//import com.example.akr_server.repository.PartyDetailRepository;


@Service
@EnableMongoRepositories
public class PartyDetailService {

	@Autowired
	PartyDetailRepository partyDetailRepository;
	
	public List<PartyDetail> getAllPartyDetails(){
		
		return partyDetailRepository.findAll();
	}
	
	public PartyDetail createPartyDetail(PartyDetail partyDetail) {
		return partyDetailRepository.save(partyDetail);
	}

	public void deleterPartyEntryById(String partyId) {
		
		try {
			partyDetailRepository.deleteById(partyId);
		}catch (Exception e) {
			System.out.println("Error:"+e.getMessage());
		}
		
	}
}

