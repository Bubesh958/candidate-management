package com.accolite.aumanagement.candidate_management.service.service_impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.aumanagement.candidate_management.controller.CandidateController;
import com.accolite.aumanagement.candidate_management.dao.CandidateDao;
import com.accolite.aumanagement.candidate_management.dao.EmpSkillDao;
import com.accolite.aumanagement.candidate_management.model.Candidate;
import com.accolite.aumanagement.candidate_management.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService 
{
	@Autowired
	CandidateDao candidateDao;
	
	@Autowired
	EmpSkillDao empSkillDao;
	

	
	@Override
	public List<Candidate> getAllCandidate()
	{
		return candidateDao.getAllCandidate();
	}
	
	@Override
	public List<Candidate> getCandidateByEmpId(String empid)
	{
		return candidateDao.getCandidateByEmpId(empid);
	}
	
	@Override
	public List<Candidate> getCandidateByLocation(String location)
	{
		return candidateDao.getCandidateByLocation(location);
	}
	
	@Override
	public List<Candidate> getCandidateByInstitute(String institute)
	{
		return candidateDao.getCandidateByInstitute(institute);
	}
	
	@Override
	public List<Candidate> getCandidateByJobDescription(String jobdescription)
	{
		return candidateDao.getCandidateByJobDescription(jobdescription);
	}
	
	@Override
	public List<Candidate> getCandidateBySkill(String skill)
	{
		return candidateDao.getCandidateBySkill(skill);
	}
	
	@Override
	public List<String> getAllCandidateEmpIds()
	{
		return candidateDao.getAllCandidateEmpIds();
	}
	
	@Override
	public boolean saveCandidate(Candidate candidate)
	{
		return candidateDao.saveCandidate(candidate);
	}
	
	@Override
	public boolean updateCandidate(Candidate candidate)
	{
		return candidateDao.updateCandidate(candidate);
	}
	
	@Override
	public boolean deleteCandidateById(String empId)
	{
		return candidateDao.deleteCandidateById(empId);
	}
	
	
}