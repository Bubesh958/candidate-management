package com.accolite.aumanagement.candidate_management.service.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.aumanagement.candidate_management.dao.EmpSkillDao;
import com.accolite.aumanagement.candidate_management.model.EmpSkill;
import com.accolite.aumanagement.candidate_management.service.EmpSkillService;

@Service
public class EmpSkillServiceImpl implements EmpSkillService 
{
	@Autowired
	EmpSkillDao empSkillDao;
	
	@Override
	public List<EmpSkill> getEmpSkills()
	{
		return empSkillDao.getEmpSkills();
	}
	
	@Override
	public boolean saveEmpSkill(List<EmpSkill> empSkills)
	{
		return empSkillDao.saveEmpSkill(empSkills);
	}
	
	@Override
	public boolean deleteEmpSkillById(String empid)
	{
		return empSkillDao.deleteEmpSkillById(empid);
	}
	
	
	
}
