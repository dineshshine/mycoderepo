package com.sis.ExcelReport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "com.sis.ExcelReport")
@EnableScheduling
public class ExcelReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelReportApplication.class, args);
		System.out.println("application started!!..");
	}

}
