package com.accolite.aumanagement.candidate_management.dao.dao_impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.candidate_management.dao.EmpSkillDao;
import com.accolite.aumanagement.candidate_management.model.EmpSkill;
import com.accolite.aumanagement.candidate_management.model.Skill;
import com.accolite.aumanagement.candidate_management.model.mapper.EmpSkillRowMapper;

@Repository
public class EmpSkillDaoImpl implements EmpSkillDao 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<EmpSkill> getEmpSkills()
	{
		String SELECT_ALL_EMPSKILL = "select * from emp_skills";
		try
		{
			return jdbcTemplate.query(SELECT_ALL_EMPSKILL, new EmpSkillRowMapper());
		}
		catch(DataAccessException e)
		{
			return null;
		}
	}

	
	@Override
	public boolean saveEmpSkill(List<EmpSkill> empSkills)
	{
		String INSERT_INTO_EMPSKILL = "INSERT INTO emp_skills VALUES (?,?)";
		try
		{
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
		catch(DataAccessException e)
		{
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deleteEmpSkillById(String empid)
	{
		String DELETE_EMPSKILLS_BY_ID = "DELETE from emp_skills where empid = ?";
		
		try
		{
			jdbcTemplate.update(DELETE_EMPSKILLS_BY_ID,empid);
		}
		catch(DataAccessException e)
		{
			return false;
		}
		return true;
	}
	
	
}
