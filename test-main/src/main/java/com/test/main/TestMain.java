/*
 * Product: OMotor
 * Copyright (C) 2017 OMotor. All Rights Reserved.
 */
package com.test.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.test.config.DataBaseConfig;

/**
 * Start da aplicação
 * @author esdrastavares
 *
 */
@SpringBootApplication
@ComponentScan({
	"com.test.api",
	"com.test.service"
})
@Import(DataBaseConfig.class)
public class TestMain {

	public static void main(String[] args) {
		SpringApplication.run(TestMain.class, args);
	}

}
