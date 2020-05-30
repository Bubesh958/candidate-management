package com.accolite.aumanagement.candidate_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.candidate_management.model.Skill;
import com.accolite.aumanagement.candidate_management.repository.SkillRepository;

@RestController
@RequestMapping("/skills")
public class SkillController 
{
	@Autowired
	SkillRepository skillRepository;
	
	@GetMapping
	public List<Skill> getAllSkills()
	{
		return skillRepository.getSkill();
	}
}
