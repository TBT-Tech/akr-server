package com.example.akr_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.akr_server.service.DashboardService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/akr/api")
@CrossOrigin(origins = {"http://localhost:5173/","https://akr-client.web.app"})
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping(path="/fetchDashboardStatsData", produces=MediaType.APPLICATION_JSON_VALUE)
	public JsonNode getDashboardStatsData() {
		
				
		ObjectMapper mapper = new ObjectMapper();
		JsonNode responseJsonNode = mapper.createObjectNode();
		
		((ObjectNode) responseJsonNode).put("Revenue", dashboardService.getTotalMoneyInflow());
		((ObjectNode) responseJsonNode).put("Expense Paid", dashboardService.getTotalMoneyOutflow());
		((ObjectNode) responseJsonNode).put("Total Bank Balance", dashboardService.getOwnAccountTotalBalance());
		((ObjectNode) responseJsonNode).put("Order Book", dashboardService.getTotalBuyerBilledAmount());
		((ObjectNode) responseJsonNode).put("Total Payables", dashboardService.getTotalSupplierBilledAmount());
		
		System.out.println(responseJsonNode);
//		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
		return responseJsonNode;
	}

}
