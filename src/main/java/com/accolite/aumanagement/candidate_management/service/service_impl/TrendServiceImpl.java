package com.accolite.aumanagement.candidate_management.service.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.aumanagement.candidate_management.dao.TrendDao;
import com.accolite.aumanagement.candidate_management.model.Trend;
import com.accolite.aumanagement.candidate_management.service.TrendService;

@Service
public class TrendServiceImpl implements TrendService 
{
	@Autowired
	TrendDao trendDao;
	
	@Override
	public List<Trend> getSkillsCount()
	{
		return trendDao.getSkillsCount();
	}
	
	@Override
	public List<Trend> getInstitutesCount()
	{
		return trendDao.getInstitutesCount();
	}
	
	@Override
	public List<Trend> getLocationsCount()
	{
		return trendDao.getLocationsCount();
	}
}
