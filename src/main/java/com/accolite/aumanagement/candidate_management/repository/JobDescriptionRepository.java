package com.accolite.aumanagement.candidate_management.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.candidate_management.model.Institute;
import com.accolite.aumanagement.candidate_management.model.JobDescription;
import com.accolite.aumanagement.candidate_management.model.mapper.InstituteRowMappper;
import com.accolite.aumanagement.candidate_management.model.mapper.JobDescriptionRowMapper;


@Repository
public class JobDescriptionRepository 
{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<JobDescription> getAllJobDescriptions()
	{
		return jdbcTemplate.query("select * from jobdescriptions", new JobDescriptionRowMapper());
	}

}
