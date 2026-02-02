package com.traineeMgmtApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = "com.traineeMgmtApp")

public class TestModule3Application {

	public static void main(String[] args) {
		SpringApplication.run(TestModule3Application.class, args);
	}

}


