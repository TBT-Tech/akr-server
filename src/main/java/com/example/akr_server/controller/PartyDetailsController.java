package com.example.akr_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.akr_server.bean.PartyDetail;
import com.example.akr_server.repository.PartyDetailRepository;
import com.example.akr_server.service.PartyDetailService;

@RestController
@RequestMapping("/akr/api")
@CrossOrigin(origins = {"http://localhost:5173","https://akr-client.web.app"})
public class PartyDetailsController {
	
	
	@Autowired
	PartyDetailService partyDetailService;
	
//	@Autowired
//	PartyDetailRepository partyDetailRepository;
	
	@GetMapping("/fetchAllPartyDetails")
	public List<PartyDetail> getAllPartyDetails() {
		return partyDetailService.getAllPartyDetails();
//		return partyDetailRepository.findAll();
	}
	
	@PostMapping("/createPartyEntry")
	public PartyDetail addPartyEntry(@RequestBody PartyDetail partyDetail) {
		return partyDetailService.createPartyDetail(partyDetail);
//		return partyDetailRepository.save(partyDetail);
	}
	
	@DeleteMapping("/deletePartyEntryById/{partyId}")
	public void deletePartyEntryById(@PathVariable String partyId) {
		partyDetailService.deleterPartyEntryById(partyId);
		
	}
}
