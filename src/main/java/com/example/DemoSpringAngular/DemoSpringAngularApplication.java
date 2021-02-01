package com.example.DemoSpringAngular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan("com.example")
public class DemoSpringAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringAngularApplication.class, args);
	}

}
