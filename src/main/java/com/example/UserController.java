package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserController {
	
	@GetMapping("/")
	public String username() {
		return "My name is sunny";
	}

}
