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

import com.example.akr_server.pojo.Company;
import com.example.akr_server.repository.CompanyRepository;
import com.example.akr_server.service.CompanyService;

@RestController
@RequestMapping("/akr/api")
@CrossOrigin(origins = {"http://localhost:5173/","https://akr-client.web.app"})
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
//	@Autowired
//	CompanyRepository companyRepository;
	
	@GetMapping("/fetchAllCompany")
	public List<Company> getAllCompany() {
		return companyService.getAllActiveCompany();
//		return companyRepository.findAll();
	}
		
	@GetMapping("/fetchAllCompanyByCompanyType/{companyType}")
	public List<Company> getAllCompanyByCompanyType(String companyType) {
		return companyService.getAllActiveCompanyByCompanyType(companyType);
	}
	
	@PostMapping("/createCompany")
	public Company createCompany(@RequestBody Company company) {
		return companyService.createCompany(company);
//		return companyRepository.save(partyDetail);
	}
	
	@DeleteMapping("/deleteCompanyById/{companyId}")
	public void deleteCompanyById(@PathVariable String companyId) {
		companyService.deleteCompanyById(companyId);
		
	}
}
