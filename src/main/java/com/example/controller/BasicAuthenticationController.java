package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AuthenticationBean;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BasicAuthenticationController {
	
	@GetMapping(path="/basicauth")
	public AuthenticationBean authenticateUser() {
		return new AuthenticationBean("You are Authenticated");
	}

}
