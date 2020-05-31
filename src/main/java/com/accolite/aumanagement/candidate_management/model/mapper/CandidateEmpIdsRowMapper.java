package com.accolite.aumanagement.candidate_management.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.aumanagement.candidate_management.model.Institute;




public class CandidateEmpIdsRowMapper implements RowMapper<String>
{

	@Override
	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		String CandidateEmpId = rs.getString("empid");
		return CandidateEmpId;
	}
	

}
