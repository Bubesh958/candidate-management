package com.accolite.aumanagement.candidate_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.candidate_management.dao.SkillDao;
import com.accolite.aumanagement.candidate_management.model.Location;
import com.accolite.aumanagement.candidate_management.model.Skill;
import com.accolite.aumanagement.candidate_management.service.SkillService;

@CrossOrigin
@RestController
@RequestMapping("/skills")
public class SkillController 
{
	@Autowired
	SkillService skillService;
	
	@GetMapping
	public ResponseEntity<?> getAllSkills()
	{
		List<Skill> skills = null;
		skills = skillService.getSkills();
		if(skills.isEmpty())
			return new ResponseEntity<String>("Empty",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Skill>>(skills,HttpStatus.OK);
	}
	
	

}
