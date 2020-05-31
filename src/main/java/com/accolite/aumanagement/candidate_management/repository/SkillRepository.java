package com.accolite.aumanagement.candidate_management.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.candidate_management.model.Skill;
import com.accolite.aumanagement.candidate_management.model.mapper.SkillRowMapper;

@Repository
public class SkillRepository 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Skill> getSkills()
	{
		try {
			return jdbcTemplate.query("select * from skills", new SkillRowMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}

}
