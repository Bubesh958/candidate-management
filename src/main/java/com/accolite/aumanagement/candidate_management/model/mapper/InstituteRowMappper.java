package com.accolite.aumanagement.candidate_management.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.aumanagement.candidate_management.model.Institute;

public class InstituteRowMappper implements RowMapper<Institute>
{

	@Override
	public Institute mapRow(ResultSet rs, int rowNum) throws SQLException {
		Institute institute = new Institute();
		institute.setInstituteid(rs.getInt("instituteid"));
		institute.setInstitute(rs.getString("institute"));
		return institute;
	}
	

}
