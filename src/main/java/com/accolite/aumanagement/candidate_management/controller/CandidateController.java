package com.accolite.aumanagement.candidate_management.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.candidate_management.model.Candidate;
import com.accolite.aumanagement.candidate_management.model.EmpSkill;
import com.accolite.aumanagement.candidate_management.repository.CandidateRepository;
import com.accolite.aumanagement.candidate_management.repository.EmpSkillRepository;
import com.accolite.aumanagement.candidate_management.repository.SkillRepository;

@CrossOrigin
@RestController
@RequestMapping("/candidates")
public class CandidateController 
{
	@Autowired
	CandidateRepository candidateRepository;
	
	@Autowired
	EmpSkillRepository empSkillRepository;
	
	@GetMapping
	public ResponseEntity<?> getAllCandidates()
	{
		List<Candidate> candidates = candidateRepository.getAllCandidate();
		if(candidates.isEmpty())
		{
			return new ResponseEntity<String>("Empty",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Candidate>>(candidates,HttpStatus.OK);
	}
	
	@GetMapping("/{empid}")
	public ResponseEntity<?> getCandidateById(@PathVariable("empid") String empid)
	{
		List<Candidate> candidate = candidateRepository.getCandidateByEmpId(empid);
		if(candidate.isEmpty())
		{
			return new ResponseEntity<String>(" The Emp Id Not Empty",HttpStatus.NOT_FOUND); 
		}
		else
		{
			return new ResponseEntity<List<Candidate>>(candidate,HttpStatus.OK);
		}
	}
	
	@GetMapping("/{value}")
	public ResponseEntity<?> getCandidateBy(@RequestParam(value="by") String by,@PathVariable("value") String value)
	{
		List<Candidate> candidate = null;
		if(by.equals("id"))
				candidate = candidateRepository.getCandidateByEmpId(value);
		else
			if(by.equals("location"))
				candidate = candidateRepository.get
		return null;
	}
	
	
	@PostMapping
	public ResponseEntity<String> createCandidate(@RequestBody Candidate candidate)
	{
		if(candidateRepository.getCandidateByEmpId(candidate.getEmpid()).isEmpty())
		{
			candidateRepository.saveCandidate(candidate);
			List<EmpSkill> empskills = (candidate.getSkills()
										.stream()
										.map(s -> new EmpSkill(candidate.getEmpid(),s.getSkillid()))
										.collect(Collectors.toList()) 
										);
			empSkillRepository.saveEmpSkill(empskills);
			return new ResponseEntity("Created",HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity("Duplicate Entry",HttpStatus.IM_USED);
		}
	}
}


