package com.nitin.jobConnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class JobConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobConnectApplication.class, args);
		System.out.println("----------------------------Job-Connect Application started!----------------------------");
	}

}
