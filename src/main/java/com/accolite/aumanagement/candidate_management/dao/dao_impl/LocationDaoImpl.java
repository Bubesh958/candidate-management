package com.accolite.aumanagement.candidate_management.dao.dao_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.candidate_management.dao.LocationDao;
import com.accolite.aumanagement.candidate_management.model.Location;
import com.accolite.aumanagement.candidate_management.model.mapper.LocationRowMapper;



@Repository
public class LocationDaoImpl implements LocationDao 
{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Location> getAllLocations()
	{
		try {
			return jdbcTemplate.query("select * from locations", new LocationRowMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}

}
