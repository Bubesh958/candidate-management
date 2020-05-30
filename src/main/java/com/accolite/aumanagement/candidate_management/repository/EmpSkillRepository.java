package com.accolite.aumanagement.candidate_management.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.candidate_management.model.EmpSkill;
import com.accolite.aumanagement.candidate_management.model.Skill;
import com.accolite.aumanagement.candidate_management.model.mapper.EmpSkillRowMapper;

@Repository
public class EmpSkillRepository 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<EmpSkill> getEmpSkill()
	{
		return jdbcTemplate.query("select * from emp_skills", new EmpSkillRowMapper());
	}

	
	public void saveEmpSkill(List<EmpSkill> empSkills)
	{
		String INSERT_INTO_EMPSKILL = "INSERT INTO emp_skills VALUES (?,?)";
		int[] updateCounts = jdbcTemplate.batchUpdate(INSERT_INTO_EMPSKILL,
				new BatchPreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps,int i) throws SQLException {
						EmpSkill empSkill = empSkills.get(i);
						ps.setString(1, empSkill.getEmpid());
						ps.setInt(2, empSkill.getSkillid());
					}

					@Override
					public int getBatchSize() {
						return empSkills.size();
					}
				}
				);
	}
	
	
	
}
