package com.accolite.aumanagement.candidate_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.candidate_management.model.Candidate;
import com.accolite.aumanagement.candidate_management.repository.CandidateRepository;

@RestController
@RequestMapping("/candidates")
public class CandidateController 
{
	@Autowired
	CandidateRepository candidateRepository;
	
	@GetMapping
	public List<Candidate> getAllCandidates()
	{
		return candidateRepository.getCandidate();
	}
}
