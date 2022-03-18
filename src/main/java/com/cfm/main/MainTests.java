package com.cfm.main;

import org.springframework.boot.SpringApplication;

/*
 * Main Application
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * Main Configuration Class! 
 * Params - @ComponentScan, @SpringBootApplication
 */
@ComponentScan({"com.cfm"})
@SpringBootApplication
public class MainTests {

	/*
	 * Run the actual application!
	 */
	public static void main(String[] args) {
		System.out.println("Hero!");
		SpringApplication.run(MainTests.class, args);
	}

}
