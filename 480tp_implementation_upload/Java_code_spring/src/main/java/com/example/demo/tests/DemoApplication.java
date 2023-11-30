package com.example.demo.tests;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;




@SpringBootApplication
@RestController
@RequestMapping("/spring-entry")
public class DemoApplication {

	@GetMapping("/start")
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}