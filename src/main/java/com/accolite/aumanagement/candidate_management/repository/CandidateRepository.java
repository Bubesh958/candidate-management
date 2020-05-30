package com.accolite.aumanagement.candidate_management.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.candidate_management.model.Candidate;
import com.accolite.aumanagement.candidate_management.model.mapper.CandidateAllDetailsMapper;

@Repository
public class CandidateRepository 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Candidate> getAllCandidate()
	{	
		String CANDIDATES_WITH_ALL_DETAILS = "SELECT candidates.empid,candidates.firstname,candidates.lastname,candidates.instituteid,institutes.institute,emp_skills.skillid,skills.skill,candidates.locationid,locations.location,candidates.joiningdate,candidates.jobdescriptionid,jobdescriptions.jobdescription,candidates.feedback,candidates.contactnumber,candidates.email FROM candidates LEFT JOIN emp_skills ON candidates.empid  = emp_skills.empid LEFT JOIN skills ON emp_skills.skillid = skills.skillid LEFT JOIN institutes ON candidates.instituteid = institutes.instituteid LEFT JOIN locations ON candidates.locationid = locations.locationid LEFT JOIN jobdescriptions ON candidates.jobdescriptionid = jobdescriptions.jobdescriptionid;";
		
		return jdbcTemplate.query(CANDIDATES_WITH_ALL_DETAILS, new CandidateAllDetailsMapper());
	}

	public List<Candidate> getCandidateByEmpId(String empid)
	{
		String CANDIDATE_BY_ID = "SELECT candidates.empid,candidates.firstname,candidates.lastname,candidates.instituteid,institutes.institute,emp_skills.skillid,skills.skill,candidates.locationid,locations.location,candidates.joiningdate,candidates.jobdescriptionid,jobdescriptions.jobdescription,candidates.feedback,candidates.contactnumber,candidates.email FROM candidates LEFT JOIN emp_skills ON candidates.empid  = emp_skills.empid LEFT JOIN skills ON emp_skills.skillid = skills.skillid LEFT JOIN institutes ON candidates.instituteid = institutes.instituteid LEFT JOIN locations ON candidates.locationid = locations.locationid LEFT JOIN jobdescriptions ON candidates.jobdescriptionid = jobdescriptions.jobdescriptionid where candidates.empid = '"+empid+"';";

		return jdbcTemplate.query(CANDIDATE_BY_ID, new CandidateAllDetailsMapper());
	}
	
	
	public void saveCandidate(Candidate candidate)
	{
		String INSERT_INTO_CANDIDATE = "INSERT INTO candidates VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		jdbcTemplate.execute(INSERT_INTO_CANDIDATE,new PreparedStatementCallback<Boolean>() {
		@Override
		public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException,DataAccessException
			{
				ps.setString(1, candidate.getEmpid());
				ps.setString(2, candidate.getFirstname());
				ps.setString(3, candidate.getLastname());
				ps.setInt(4, candidate.getInstituteid());
				ps.setInt(5, candidate.getLocationid());
				ps.setDate(6, candidate.getJoiningdate());
				ps.setInt(7, candidate.getJobdescriptionid());
				ps.setString(8, candidate.getFeedback());
				ps.setString(9, candidate.getContactnumber());
				ps.setString(10, candidate.getEmail());
				return ps.execute();
			}
		});
		
	}
	
	
	
	

	
	
	
	
}
