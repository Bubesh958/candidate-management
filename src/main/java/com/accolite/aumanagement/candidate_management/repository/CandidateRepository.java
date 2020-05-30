package com.accolite.aumanagement.candidate_management.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.candidate_management.model.Candidate;
import com.accolite.aumanagement.candidate_management.model.CandidateRowMapper;

@Repository
public class CandidateRepository 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Candidate> getCandidate()
	{
		return jdbcTemplate.query("select * from candidates", new CandidateRowMapper());
	}

}
