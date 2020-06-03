package com.accolite.aumanagement.candidate_management.service.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.aumanagement.candidate_management.dao.JobDescriptionDao;
import com.accolite.aumanagement.candidate_management.model.JobDescription;
import com.accolite.aumanagement.candidate_management.service.JobDescriptionService;

@Service
public class JobDescriptionServiceImpl implements JobDescriptionService 
{
	@Autowired
	JobDescriptionDao jobDescriptionDao;
	
	@Override
	public List<JobDescription> getAllJobDescriptions()
	{
		return jobDescriptionDao.getAllJobDescriptions();
	}
	
	
}
