package com.accolite.aumanagement.candidate_management.dao.dao_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.candidate_management.dao.TrendDao;
import com.accolite.aumanagement.candidate_management.model.Trend;
import com.accolite.aumanagement.candidate_management.model.mapper.TrendRowMapper;

@Repository
public class TrendDaoImpl implements TrendDao
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Trend> getSkillsCount()
	{
		try {
			return jdbcTemplate.query("SELECT COUNT(emp_skills.skillid) AS count ,skills.skill as label FROM emp_skills LEFT JOIN skills ON emp_skills.skillid = skills.skillid GROUP BY skills.skill", new TrendRowMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	@Override
	public List<Trend> getInstitutesCount()
	{
		try {
			return jdbcTemplate.query("SELECT COUNT(institutes.institute) AS count, institutes.institute AS label FROM candidates LEFT JOIN institutes ON candidates.instituteid = institutes.instituteid GROUP BY institutes.institute;", new TrendRowMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	@Override
	public List<Trend> getLocationsCount()
	{
		try {
			return jdbcTemplate.query("SELECT COUNT(locations.location) AS count, locations.location AS label FROM candidates LEFT JOIN locations ON candidates.locationid = locations.locationid GROUP BY locations.location;", new TrendRowMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}
}
