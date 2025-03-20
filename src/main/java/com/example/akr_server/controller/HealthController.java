package com.example.akr_server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HealthController {

	@GetMapping("/sample")
	public String sampleAPI(){
		return "Sample";
	}
	@GetMapping("/health")
	public String serverHealthCheckAPI(){
		return "Server Up and Running!";
	}

    @GetMapping("/")
    public String apiHealth(){
        return "API Health: Service Up and Running!";
    }
}