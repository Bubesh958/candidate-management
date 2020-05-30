package com.accolite.aumanagement.candidate_management.model.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.accolite.aumanagement.candidate_management.model.Candidate;
import com.accolite.aumanagement.candidate_management.model.Skill;



public class CandidateAllDetailsMapper implements ResultSetExtractor<List<Candidate>>
{
	@Override
	public List<Candidate> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Candidate> candidates = new ArrayList<Candidate>();
		Map<String,List<Skill>> empholder = new HashMap<>(); 
		while(rs.next())
		{
			String empid = rs.getString("empid");
			String skill = rs.getString("skill");
			int skillid = rs.getInt("skillid");
			if(empholder.containsKey(empid))
			{
				empholder.get(empid).add(new Skill(skillid,skill));
			}
			else
			{
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				int instituteid = rs.getInt("instituteid");
				String institute = rs.getString("institute");
				int locationid = rs.getInt("locationid");
				String location = rs.getString("location");
				Date joiningdate = rs.getDate("joiningdate");
				int jobdescriptionid = rs.getInt("jobdescriptionid");
				String jobdescription = rs.getString("jobdescription");
				String feedback = rs.getString("feedback");
				String contactnumber = rs.getString("contactnumber");
				String email = rs.getString("email");
				Candidate candidate = new Candidate(empid,firstname,lastname,instituteid,institute,new ArrayList<>(),locationid,location,joiningdate,jobdescriptionid,jobdescription,feedback,contactnumber,email);
				candidates.add(candidate);
				empholder.put(empid, new ArrayList<Skill>()
												{
														{
															add(new Skill(skillid,skill));
														}
												});
			}
			
		}
		
		for(Candidate candidate:candidates)
		{
			candidate.setSkills(empholder.get(candidate.getEmpid()));
		}
		return candidates;
	}
	
}

//
//private static final class CandidateSkillMapper implements ResultSetExtractor<Map<String, List<String>>> {
//@Override
//public Map<String, List<String>> extractData(ResultSet rs) throws SQLException {
//Map<String, List<String>> employeesMap = new HashMap<>();
//while (rs.next()) {
//String country = rs.getString("country");
//String employeeName = rs.getString("employee");
//List<String> employees = employeesMap.get(country);
//            if (employees == null) {
//List<String> newEmployees = new ArrayList<>();
//              newEmployees.add(employeeName);
//employeesMap.put(country, newEmployees);
//            } else {
// employees.add(employeeName);
//            }
//        }
//        return employeesMap;
//    }
//}
//
//package com.accolite.aumanagement.candidate_management.model.mapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;

//public class CandidateRowMapper implements RowMapper<Candidate>
//{
//
//	@Override
//	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
//		Candidate candidate = new Candidate();
//		candidate.setEmpid(rs.getString("empid"));
//		candidate.setFirstname(rs.getString("firstname"));
//		candidate.setLastname(rs.getString("lastname"));
//		candidate.setInstituteid(rs.getInt("instituteid"));
//		candidate.setLocationid(rs.getInt("locationid"));
//		candidate.setJoiningdate(rs.getDate("joiningdate"));
//		candidate.setJobdescription(rs.getInt("jobdescriptionid"));
//		candidate.setFeedback(rs.getString("feedback"));
//		candidate.setContactnumber(rs.getString("contactnumber"));
//		candidate.setEmail(rs.getString("email"));
//		return candidate;
//	}
//	
//
//}
