package com.accolite.aumanagement.candidate_management.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.candidate_management.model.JobDescription;
import com.accolite.aumanagement.candidate_management.service.JobDescriptionService;

@CrossOrigin
@RestController
@RequestMapping("/jobdescriptions")
public class JobDescriptionController 
{
	@Autowired
	JobDescriptionService jobDescriptionService;
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(CandidateController.class);
	
	
	@GetMapping
	public ResponseEntity<?> getAllJobDescriptions()
	{
		logger.info("Requesting For All JobDescriptions");
		List<JobDescription> jobDescriptions = null;
		jobDescriptions = jobDescriptionService.getAllJobDescriptions();
		if(jobDescriptions.isEmpty())
		{
			logger.error(HttpStatus.NOT_FOUND.toString());
			return new ResponseEntity<String>("Empty",HttpStatus.NOT_FOUND);
		}
		logger.info(HttpStatus.OK.toString());
		return new ResponseEntity<List<JobDescription>>(jobDescriptions,HttpStatus.OK);
	}
}
