package com.accolite.aumanagement.candidate_management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
//@EnableJpaRepositories
public class CandidateManagementApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CandidateManagementApplication.class, args);
	}

}
