package com.accolite.aumanagement.candidate_management.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.aumanagement.candidate_management.model.EmpSkill;

public class EmpSkillRowMapper implements RowMapper<EmpSkill>
{

	@Override
	public EmpSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmpSkill empskill = new EmpSkill();
		empskill.setSkillid(rs.getInt("skillid"));
		empskill.setEmpid(rs.getString("empid"));
		return empskill;
	}
	

}
