package com.example.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldController {

	@GetMapping("/hello")
	public String HelloWorld() {
		return "hello";
	}
	
	@GetMapping("/hello-bean")
	public HelloWorldBean HelloWorldBean() {
		//throw new RuntimeException("Some Exception is occured. Please contact support team on ****_*****");
		return new HelloWorldBean("1", "Sunny");
	}
	
	@GetMapping("/hello-bean/path-variable/{name}")
	public HelloWorldBean helloPathvariable(@PathVariable String name) {
		return new HelloWorldBean("2",String.format("Name- %s", name));
	}
}
