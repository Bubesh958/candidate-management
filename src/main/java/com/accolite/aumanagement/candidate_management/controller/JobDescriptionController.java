package com.accolite.aumanagement.candidate_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.candidate_management.model.Institute;
import com.accolite.aumanagement.candidate_management.model.JobDescription;
import com.accolite.aumanagement.candidate_management.repository.InstituteRepository;
import com.accolite.aumanagement.candidate_management.repository.JobDescriptionRepository;

@CrossOrigin
@RestController
@RequestMapping("/jobdescriptions")
public class JobDescriptionController 
{
	@Autowired
	JobDescriptionRepository jobDescriptionRepository;
	
	@GetMapping
	public List<JobDescription> getAllJobDescriptions()
	{
		return jobDescriptionRepository.getAllJobDescriptions();
	}
}