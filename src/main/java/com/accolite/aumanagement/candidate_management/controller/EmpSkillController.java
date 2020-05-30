package com.accolite.aumanagement.candidate_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.candidate_management.model.EmpSkill;
import com.accolite.aumanagement.candidate_management.repository.EmpSkillRepository;


@RestController
@RequestMapping("/empskills")
public class EmpSkillController 
{
	@Autowired
	EmpSkillRepository empSkillRepository;
	
	@GetMapping
	public List<EmpSkill> getAllEmpSkills()
	{
		return empSkillRepository.getEmpSkill();
	}
}

