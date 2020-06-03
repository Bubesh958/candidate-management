package com.accolite.aumanagement.candidate_management.dao.dao_impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.candidate_management.dao.CandidateDao;
import com.accolite.aumanagement.candidate_management.model.Candidate;
import com.accolite.aumanagement.candidate_management.model.mapper.CandidateAllDetailsMapper;
import com.accolite.aumanagement.candidate_management.model.mapper.CandidateEmpIdsRowMapper;

@Repository
public class CandidateDaoImpl implements CandidateDao 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Candidate> getAllCandidate()
	{	
		String CANDIDATES_WITH_ALL_DETAILS = "SELECT candidates.empid,candidates.firstname,candidates.lastname,candidates.instituteid,institutes.institute,emp_skills.skillid,skills.skill,candidates.locationid,locations.location,candidates.joiningdate,candidates.jobdescriptionid,jobdescriptions.jobdescription,candidates.feedback,candidates.contactnumber,candidates.email FROM candidates LEFT JOIN emp_skills ON candidates.empid  = emp_skills.empid LEFT JOIN skills ON emp_skills.skillid = skills.skillid LEFT JOIN institutes ON candidates.instituteid = institutes.instituteid LEFT JOIN locations ON candidates.locationid = locations.locationid LEFT JOIN jobdescriptions ON candidates.jobdescriptionid = jobdescriptions.jobdescriptionid;";
		
		return jdbcTemplate.query(CANDIDATES_WITH_ALL_DETAILS, new CandidateAllDetailsMapper());
	}
	


	@Override
	public List<Candidate> getCandidateByEmpId(String empid)
	{
		StringBuilder pattern = new StringBuilder();

		for (char c: empid.toCharArray()) {
		   pattern.append(c).append("%");
		}
		
//		System.out.println(pattern);
		
		String CANDIDATE_BY_ID = "SELECT candidates.empid,candidates.firstname,candidates.lastname,candidates.instituteid,institutes.institute,emp_skills.skillid,skills.skill,candidates.locationid,locations.location,candidates.joiningdate,candidates.jobdescriptionid,jobdescriptions.jobdescription,candidates.feedback,candidates.contactnumber,candidates.email FROM candidates LEFT JOIN emp_skills ON candidates.empid  = emp_skills.empid LEFT JOIN skills ON emp_skills.skillid = skills.skillid LEFT JOIN institutes ON candidates.instituteid = institutes.instituteid LEFT JOIN locations ON candidates.locationid = locations.locationid LEFT JOIN jobdescriptions ON candidates.jobdescriptionid = jobdescriptions.jobdescriptionid where candidates.empid LIKE '%"+pattern+"';";

		try {
			return jdbcTemplate.query(CANDIDATE_BY_ID, new CandidateAllDetailsMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	@Override
	public List<Candidate> getCandidateByLocation(String location)
	{
		StringBuilder pattern = new StringBuilder();

		for (char c: location.toCharArray()) {
		   pattern.append(c).append("%");
		}
		
		
		String CANDIDATE_BY_LOCATION = "SELECT candidates.empid,candidates.firstname,candidates.lastname,candidates.instituteid,institutes.institute,emp_skills.skillid,skills.skill,candidates.locationid,locations.location,candidates.joiningdate,candidates.jobdescriptionid,jobdescriptions.jobdescription,candidates.feedback,candidates.contactnumber,candidates.email FROM candidates LEFT JOIN emp_skills ON candidates.empid  = emp_skills.empid LEFT JOIN skills ON emp_skills.skillid = skills.skillid LEFT JOIN institutes ON candidates.instituteid = institutes.instituteid LEFT JOIN locations ON candidates.locationid = locations.locationid LEFT JOIN jobdescriptions ON candidates.jobdescriptionid = jobdescriptions.jobdescriptionid where locations.location LIKE '%"+pattern+"';";
		
		try {
			return jdbcTemplate.query(CANDIDATE_BY_LOCATION, new CandidateAllDetailsMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	
	@Override
	public List<Candidate> getCandidateByInstitute(String institute)
	{
		StringBuilder pattern = new StringBuilder();

		for (char c: institute.toCharArray()) {
		   pattern.append(c).append("%");
		}
		
//		System.out.println(pattern);
		String CANDIDATE_BY_INSTITUTE = "SELECT candidates.empid,candidates.firstname,candidates.lastname,candidates.instituteid,institutes.institute,emp_skills.skillid,skills.skill,candidates.locationid,locations.location,candidates.joiningdate,candidates.jobdescriptionid,jobdescriptions.jobdescription,candidates.feedback,candidates.contactnumber,candidates.email FROM candidates LEFT JOIN emp_skills ON candidates.empid  = emp_skills.empid LEFT JOIN skills ON emp_skills.skillid = skills.skillid LEFT JOIN institutes ON candidates.instituteid = institutes.instituteid LEFT JOIN locations ON candidates.locationid = locations.locationid LEFT JOIN jobdescriptions ON candidates.jobdescriptionid = jobdescriptions.jobdescriptionid where institutes.institute LIKE '%"+pattern+"';";
		
		try {
			return jdbcTemplate.query(CANDIDATE_BY_INSTITUTE, new CandidateAllDetailsMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	@Override
	public List<Candidate> getCandidateByJobDescription(String jobdescription)
	{
		StringBuilder pattern = new StringBuilder();

		for (char c: jobdescription.toCharArray()) {
		   pattern.append(c).append("%");
		}
		
		String CANDIDATE_BY_JOBDESCRIPTION = "SELECT candidates.empid,candidates.firstname,candidates.lastname,candidates.instituteid,institutes.institute,emp_skills.skillid,skills.skill,candidates.locationid,locations.location,candidates.joiningdate,candidates.jobdescriptionid,jobdescriptions.jobdescription,candidates.feedback,candidates.contactnumber,candidates.email FROM candidates LEFT JOIN emp_skills ON candidates.empid  = emp_skills.empid LEFT JOIN skills ON emp_skills.skillid = skills.skillid LEFT JOIN institutes ON candidates.instituteid = institutes.instituteid LEFT JOIN locations ON candidates.locationid = locations.locationid LEFT JOIN jobdescriptions ON candidates.jobdescriptionid = jobdescriptions.jobdescriptionid where jobdescriptions.jobdescription LIKE '%"+pattern+"';";
		
		try {
			return jdbcTemplate.query(CANDIDATE_BY_JOBDESCRIPTION, new CandidateAllDetailsMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	@Override
	public List<Candidate> getCandidateBySkill(String skill)
	{
		StringBuilder pattern = new StringBuilder();

		for (char c: skill.toCharArray()) {
		   pattern.append(c).append("%");
		}
		
		String CANDIDATE_BY_SKILL = "SELECT candidates.empid,candidates.firstname,candidates.lastname,candidates.instituteid,institutes.institute,emp_skills.skillid,skills.skill,candidates.locationid,locations.location,candidates.joiningdate,candidates.jobdescriptionid,jobdescriptions.jobdescription,candidates.feedback,candidates.contactnumber,candidates.email FROM candidates LEFT JOIN emp_skills ON candidates.empid  = emp_skills.empid LEFT JOIN skills ON emp_skills.skillid = skills.skillid LEFT JOIN institutes ON candidates.instituteid = institutes.instituteid LEFT JOIN locations ON candidates.locationid = locations.locationid LEFT JOIN jobdescriptions ON candidates.jobdescriptionid = jobdescriptions.jobdescriptionid where skills.skill= '%"+skill+"';";
		
		try {
			return jdbcTemplate.query(CANDIDATE_BY_SKILL, new CandidateAllDetailsMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	@Override
	public List<String> getAllCandidateEmpIds()
	{
		String CANDIDATE_EMPIDS = "SELECT empid from candidates";

		try {
			return jdbcTemplate.query(CANDIDATE_EMPIDS , new CandidateEmpIdsRowMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	
	@Override
	public boolean saveCandidate(Candidate candidate)
	{
		String INSERT_INTO_CANDIDATE = "INSERT INTO candidates VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		return jdbcTemplate.execute(INSERT_INTO_CANDIDATE,new PreparedStatementCallback<Boolean>() {
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
	
	@Override
	public boolean updateCandidate(Candidate candidate)
	{
		String UPDATE_INTO_CANDIDATE = "UPDATE candidates SET firstname = ?, lastname = ?, instituteid = ?, locationid = ?, joiningdate = ?, jobdescriptionid = ?, feedback = ?, contactnumber = ?, email = ? WHERE empid = ?;";
		return jdbcTemplate.execute(UPDATE_INTO_CANDIDATE,new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException,DataAccessException
				{
					ps.setString(1, candidate.getFirstname());
					ps.setString(2, candidate.getLastname());
					ps.setInt(3, candidate.getInstituteid());
					ps.setInt(4, candidate.getLocationid());
					ps.setDate(5, candidate.getJoiningdate());
					ps.setInt(6, candidate.getJobdescriptionid());
					ps.setString(7, candidate.getFeedback());
					ps.setString(8, candidate.getContactnumber());
					ps.setString(9, candidate.getEmail());
					ps.setString(10, candidate.getEmpid());
					return ps.execute();
				}
			});
	}
	
	@Override
	public boolean deleteCandidateById(String empId)
	{
		try {
			jdbcTemplate.update("delete from emp_skills where empid= ?",empId);
			jdbcTemplate.update("delete from candidates where empid= ?",empId);
		} catch (DataAccessException e) {
			return false;
		}
		return true;
		
	}
	
	
	
	

	
	
	
	
}
