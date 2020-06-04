package com.accolite.aumanagement.candidate_management.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.candidate_management.model.Candidate;
import com.accolite.aumanagement.candidate_management.model.EmpSkill;
import com.accolite.aumanagement.candidate_management.service.CandidateService;
import com.accolite.aumanagement.candidate_management.service.EmpSkillService;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.slf4j.LoggerFactory;


@CrossOrigin
@RestController
@RequestMapping("/candidates")
public class CandidateController 
{
	@Autowired
	CandidateService candidateService;
	
	@Autowired
	EmpSkillService empSkillService;
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(CandidateController.class);
	

	@GetMapping
	public ResponseEntity<?> getAllCandidates()
	{
		logger.info("Requesting For All Candidates");
		
		
		List<Candidate> candidates = candidateService.getAllCandidate();
		if(candidates.isEmpty())
		{
			logger.error(HttpStatus.NOT_FOUND.toString());
			return new ResponseEntity<String>("Empty",HttpStatus.NOT_FOUND);
		}
		logger.info(HttpStatus.OK.toString());
		return new ResponseEntity<List<Candidate>>(candidates,HttpStatus.OK);
	}
	
	@GetMapping("/empids")
	public ResponseEntity<?> getAllCandidatesEmpId()
	{
		logger.info("Requesting For All Candidate EmpIds");
		List<String> candidatesEmpIds = candidateService.getAllCandidateEmpIds();
		if(candidatesEmpIds.isEmpty())
		{
			logger.error(HttpStatus.NOT_FOUND.toString());	
			return new ResponseEntity<String>("Empty",HttpStatus.NOT_FOUND);
		}
		logger.info(HttpStatus.OK.toString());
		return new ResponseEntity<List<String>>(candidatesEmpIds,HttpStatus.OK);
	}
	

	
	@GetMapping("/{value}")
	public ResponseEntity<?> getCandidateBy(@RequestParam(value="by") String by,@PathVariable("value") String value)
	{
		logger.info("Requesting For Candidate By " + by + " : "  + value);
		List<Candidate> candidate = null;
		switch(by)
		{
			case "all" :
				candidate = candidateService.getAllCandidate();
				break;
			case "id" :
				candidate = candidateService.getCandidateByEmpId(value);
				break;
			case "location":
				candidate = candidateService.getCandidateByLocation(value);
				break;
			case "institute":
				candidate = candidateService.getCandidateByInstitute(value);
				break;
			case "jobdescription":
				candidate = candidateService.getCandidateByJobDescription(value);
				break;
			case "skill":
				candidate = candidateService.getCandidateBySkill(value);
				break;
			default :
				logger.error(HttpStatus.NOT_FOUND.toString());	
				return new ResponseEntity<String>("Empty",HttpStatus.NOT_FOUND);
				
					
		}
		logger.info(HttpStatus.OK.toString());
		return new ResponseEntity<List<Candidate>>(candidate,HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<String> createCandidate(@RequestBody Candidate candidate)
	{
		logger.info("Requesting to Create Candidate ");
		System.out.println(candidate);
		if(candidateService.getCandidateByEmpId(candidate.getEmpid()).isEmpty())
		{
			candidateService.saveCandidate(candidate);
			List<EmpSkill> empskills = (candidate.getSkills()
										.stream()
										.map(s -> new EmpSkill(candidate.getEmpid(),s.getSkillid()))
										.collect(Collectors.toList()) 
										);
			empSkillService.saveEmpSkill(empskills);
			logger.info(HttpStatus.CREATED.toString());
			return new ResponseEntity("Created",HttpStatus.CREATED);
		}
		else
		{
			logger.warn(HttpStatus.IM_USED.toString());
			return new ResponseEntity("Duplicate Entry",HttpStatus.IM_USED);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateCandidate(@RequestBody Candidate candidate)
	{
		logger.info("Requesting to Update Candidate : "+ candidate.getEmpid());
		candidateService.updateCandidate(candidate);
		List<EmpSkill> empskills = (candidate.getSkills()
									.stream()
									.map(s -> new EmpSkill(candidate.getEmpid(),s.getSkillid()))
									.collect(Collectors.toList()) 
									);
		if(empSkillService.deleteEmpSkillById(candidate.getEmpid()) && empSkillService.saveEmpSkill(empskills))
		{
			logger.info(HttpStatus.NO_CONTENT.toString());
			return new ResponseEntity(HttpStatus.NO_CONTENT);			
		}
		else
		{
			logger.info(HttpStatus.NOT_FOUND.toString());
			return new ResponseEntity<String>("Couldn't delete.",HttpStatus.NOT_FOUND); 
		}
		
	}
	
	@DeleteMapping("/{empid}")
	public ResponseEntity deleteCandidate(@PathVariable String empid)
	{
		logger.info("Requesting to Delete Candidate : "+ empid);
		if(empSkillService.deleteEmpSkillById(empid) && candidateService.deleteCandidateById(empid))
		{
			logger.info(HttpStatus.NO_CONTENT.toString());
			return new ResponseEntity(HttpStatus.NO_CONTENT);			
		}
		else
		{
			logger.info(HttpStatus.NOT_FOUND.toString());
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}

































//
//
//@GetMapping("/test")
//public List<String> test()
//{
//	List<String> states = new ArrayList<>();
//	states.add("aaaa");
//	states.add("bbbb");
//	states.add("cccc");
//	states.add("alaska");
//	states.add("alabama");
//	states.add("eeee");
//	states.add("eeee");
//	states.add("eeee");
//	states.add("eeee");
//	states.add("eeee");
//	states.add("eeee");
//	states.add("eeee");
//	states.add("eeee");
//	states.add("eeee");
//	states.add("eeee");
//	states.add("eeee");
//	return states;
//}
//
//@GetMapping("/test1")
//public List<String> test1()
//{
//	List<String> states = new ArrayList<>();
//	states.add("aaaa");
//	states.add("bbbb");
//	states.add("cccc");
//	states.add("alaska");
//	states.add("alabama");
//	states.add("ffff");
//	states.add("ffff");
//	states.add("ffff");
//	states.add("ffff");
//	states.add("ffff");
//	states.add("ffff");
//	states.add("ffff");
//	states.add("ffff");
//	states.add("ffff");
//	states.add("ffff");
//	states.add("ffff");
//	states.add("ffff");
//	return states;
//}


