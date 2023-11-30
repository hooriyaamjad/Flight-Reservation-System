package com.example.demo.java_classes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@RestController
@RequestMapping("/test-spring")
public class DemoApplication {

	@GetMapping("/main")
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}