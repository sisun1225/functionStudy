package com.ptw.ptwProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling

@SpringBootApplication
public class PtwProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtwProjectApplication.class, args);
	}

}
