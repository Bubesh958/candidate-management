package com.accolite.aumanagement.candidate_management.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CandidateRowMapper implements RowMapper<Candidate>
{

	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate candidate = new Candidate();
		candidate.setEmpid(rs.getString("empid"));
		candidate.setFirstname(rs.getString("firstname"));
		candidate.setLastname(rs.getString("lastname"));
		candidate.setInstituteid(rs.getInt("instituteid"));
		candidate.setLocationid(rs.getInt("locationid"));
		candidate.setJoiningdate(rs.getDate("joiningdate"));
		candidate.setJobdescription(rs.getInt("jobdescriptionid"));
		candidate.setFeedback(rs.getString("feedback"));
		candidate.setContactnumber(rs.getString("contactnumber"));
		candidate.setEmail(rs.getString("email"));
		return candidate;
	}
	

}
