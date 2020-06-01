package com.accolite.aumanagement.candidate_management.dao.dao_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.candidate_management.dao.JobDescriptionDao;
import com.accolite.aumanagement.candidate_management.model.Institute;
import com.accolite.aumanagement.candidate_management.model.JobDescription;
import com.accolite.aumanagement.candidate_management.model.mapper.InstituteRowMappper;
import com.accolite.aumanagement.candidate_management.model.mapper.JobDescriptionRowMapper;


@Repository
public class JobDescriptionDaoImpl implements JobDescriptionDao 
{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<JobDescription> getAllJobDescriptions()
	{
		try {
			return jdbcTemplate.query("select * from jobdescriptions", new JobDescriptionRowMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}

}
