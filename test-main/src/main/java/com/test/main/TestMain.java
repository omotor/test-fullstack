/*
 * Product: OMotor
 * Copyright (C) 2017 OMotor. All Rights Reserved.
 */
package com.test.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Start da aplicação
 * @author esdrastavares
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.test.config", "com.test.api", "com.test.main",  "com.test.model","com.test.repository", "com.test.service"}) 
public class TestMain {

	public static void main(String[] args) {
		SpringApplication.run(TestMain.class, args);
	}
}
