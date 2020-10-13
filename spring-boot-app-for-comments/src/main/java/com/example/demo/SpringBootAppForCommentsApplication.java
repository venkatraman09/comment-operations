package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Venkatraman Athmanathan
 *
 * SpringBootAppForCommentsApplication Comment application is used to save and get Comments from the database
 */
@SpringBootApplication

public class SpringBootAppForCommentsApplication {

	/**
	 * main is start of the program
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppForCommentsApplication.class, args);
	}

}
