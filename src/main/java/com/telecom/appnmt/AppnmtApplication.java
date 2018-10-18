package com.telecom.appnmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AppnmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppnmtApplication.class, args);
	}
}
