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
//		File file = new File("D:\\sample.txt");
//	      //Instantiating the PrintStream class
//	      PrintStream stream = null;
//		try {
//			stream = new PrintStream(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	      System.out.println("From now on "+file.getAbsolutePath()+" will be your console");
//	      System.setOut(stream);
//	      //Printing values to file
//	      System.out.println("Hello, how are you");
		SpringApplication.run(CandidateManagementApplication.class, args);
	}

}
