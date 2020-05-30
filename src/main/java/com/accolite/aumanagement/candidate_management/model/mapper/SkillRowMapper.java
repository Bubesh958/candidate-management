package com.accolite.aumanagement.candidate_management.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.aumanagement.candidate_management.model.Skill;

public class SkillRowMapper implements RowMapper<Skill>
{

	@Override
	public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
		Skill skill = new Skill();
		skill.setSkillid(rs.getInt("skillid"));
		skill.setSkill(rs.getString("skill"));
		return skill;
	}
	

}
