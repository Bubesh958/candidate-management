package com.accolite.aumanagement.candidate_management.service.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.accolite.aumanagement.candidate_management.dao.LocationDao;
import com.accolite.aumanagement.candidate_management.model.Location;
import com.accolite.aumanagement.candidate_management.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService 
{
	@Autowired
	LocationDao locationDao;
	
	@Override
	public List<Location> getAllLocations()
	{
		return locationDao.getAllLocations();
	}

}
