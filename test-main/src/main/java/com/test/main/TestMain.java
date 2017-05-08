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
 *
 * @author esdrastavares
 *
 */
@SpringBootApplication
@ComponentScan({"com.test.api"})
public class TestMain {
    public static void main(String[] args) {
        SpringApplication.run(TestMain.class, args);
    }

}
