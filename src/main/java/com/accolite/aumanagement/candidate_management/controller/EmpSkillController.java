package com.accolite.aumanagement.candidate_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.candidate_management.dao.EmpSkillDao;
import com.accolite.aumanagement.candidate_management.model.EmpSkill;
import com.accolite.aumanagement.candidate_management.model.Institute;
import com.accolite.aumanagement.candidate_management.service.EmpSkillService;

@CrossOrigin
@RestController
@RequestMapping("/empskills")
public class EmpSkillController 
{
	@Autowired
	EmpSkillService empSkillService;
	

	@GetMapping
	public ResponseEntity<?> getAllEmpSkills()
	{
		List<EmpSkill> empSkills = null;
		empSkills = empSkillService.getEmpSkills();
		if(empSkills.isEmpty())
		{
			return new ResponseEntity<String>("Empty",HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<List<EmpSkill>>(empSkills,HttpStatus.OK); 
	}
}

