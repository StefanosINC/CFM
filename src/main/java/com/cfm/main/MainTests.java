package com.cfm.main;

import org.springframework.boot.SpringApplication;

/*
 * Main Application
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan({"com.cfm"})
@SpringBootApplication
public class MainTests {

	public static void main(String[] args) {
		System.out.println("Hero!");
		SpringApplication.run(MainTests.class, args);
	}

}
