package com.example.akr_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.akr_server.pojo.Bill;
import com.example.akr_server.service.BillsService;

@RestController
@RequestMapping("/akr/api")
@CrossOrigin(origins = {"http://localhost:5173/","https://akr-client.web.app"})
public class BillsController {

	@Autowired
	private BillsService billsService;
	
	@GetMapping("/fetchAllBills")
	public List<Bill> getAllBills() {
		return billsService.getAllBills();
	}
	
	@PostMapping("/addBuyerBill/{buyerAccountId}")
	public Bill addBuyerBill(@PathVariable String buyerAccountId, @RequestBody Bill buyerBill) {
		return billsService.addBuyerBill(buyerBill, buyerAccountId);
	}
	@PostMapping("/addSupplierBill/{supplierAccountId}")
	public Bill addSupplierBill(@PathVariable String supplierAccountId, @RequestBody Bill supplierBill) {
		return billsService.addSupplierBill(supplierBill, supplierAccountId);
	}
}
