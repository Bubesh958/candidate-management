package com.accolite.aumanagement.candidate_management.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.aumanagement.candidate_management.model.JobDescription;




public class JobDescriptionRowMapper implements RowMapper<JobDescription>
{

	@Override
	public JobDescription mapRow(ResultSet rs, int rowNum) throws SQLException {
		JobDescription jobDescription = new JobDescription();
		jobDescription.setJobdescriptionid(rs.getInt("jobdescriptionid"));
		jobDescription.setJobdescription(rs.getString("jobdescription"));
		return jobDescription;
	}
	

}
