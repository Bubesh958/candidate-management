package com.accolite.aumanagement.candidate_management.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.accolite.aumanagement.candidate_management.model.Candidate;

public interface CandidateDao {

	List<Candidate> getAllCandidate() throws DataAccessException;

	List<Candidate> getCandidateByEmpId(String empid) throws DataAccessException;

	List<Candidate> getCandidateByLocation(String location) throws DataAccessException;

	List<Candidate> getCandidateByInstitute(String institute) throws DataAccessException;

	List<Candidate> getCandidateByJobDescription(String jobdescription) throws DataAccessException;

	List<Candidate> getCandidateBySkill(String skill) throws DataAccessException;

	List<String> getAllCandidateEmpIds() throws DataAccessException;

	boolean saveCandidate(Candidate candidate) throws DataAccessException;

	boolean updateCandidate(Candidate candidate) throws DataAccessException;

	boolean deleteCandidateById(String empId) throws DataAccessException;

}