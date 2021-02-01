package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Register;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RegistrationController {

	@PostMapping("/register")
	public ResponseEntity<String> register(HttpServletRequest request,@RequestBody Register register ) {
		Register registerData = register;
		System.out.println("Register Value is "+registerData);
		return null;
	}
}
