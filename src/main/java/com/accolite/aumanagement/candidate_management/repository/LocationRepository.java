package com.accolite.aumanagement.candidate_management.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.candidate_management.model.Location;
import com.accolite.aumanagement.candidate_management.model.mapper.LocationRowMapper;



@Repository
public class LocationRepository 
{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Location> getAllLocations()
	{
		return jdbcTemplate.query("select * from locations", new LocationRowMapper());
	}

}
