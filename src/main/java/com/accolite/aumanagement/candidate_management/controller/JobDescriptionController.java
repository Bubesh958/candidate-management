package com.accolite.aumanagement.candidate_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.candidate_management.dao.JobDescriptionDao;
import com.accolite.aumanagement.candidate_management.dao.dao_impl.InstituteDaoImpl;
import com.accolite.aumanagement.candidate_management.model.Institute;
import com.accolite.aumanagement.candidate_management.model.JobDescription;
import com.accolite.aumanagement.candidate_management.service.JobDescriptionService;

@CrossOrigin
@RestController
@RequestMapping("/jobdescriptions")
public class JobDescriptionController 
{
	@Autowired
	JobDescriptionService jobDescriptionService;
	
	@GetMapping
	public ResponseEntity<?> getAllJobDescriptions()
	{
		List<JobDescription> jobDescriptions = null;
		jobDescriptions = jobDescriptionService.getAllJobDescriptions();
		if(jobDescriptions.isEmpty())
			return new ResponseEntity<String>("Empty",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<JobDescription>>(jobDescriptions,HttpStatus.OK);
	}
}
