package com.PostgreSql.employees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesApplication {

//	private static final Logger logger = LoggerFactory.getLogger(EmployeesApplication.class);

	public static void main(String[] args) {
//		logger.info("This is info message");
//		logger.trace("This is trace message");
//		logger.error("This is error message");
//		logger.debug("This is debug message");
//		logger.warn("This is warn message");
		SpringApplication.run(EmployeesApplication.class, args);
	}

}
