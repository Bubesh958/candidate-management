package com.accolite.aumanagement.candidate_management.service.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.aumanagement.candidate_management.dao.SkillDao;
import com.accolite.aumanagement.candidate_management.model.Skill;
import com.accolite.aumanagement.candidate_management.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService 
{
	@Autowired
	SkillDao skillDao;
	
	@Override
	public List<Skill> getSkills()
	{
		return skillDao.getSkills();
	}
}
