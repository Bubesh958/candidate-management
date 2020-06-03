package com.accolite.aumanagement.candidate_management.service;

import java.util.List;

import com.accolite.aumanagement.candidate_management.model.Candidate;

public interface CandidateService {

	List<Candidate> getAllCandidate();

	List<Candidate> getCandidateByEmpId(String empid);

	List<Candidate> getCandidateByLocation(String location);

	List<Candidate> getCandidateByInstitute(String institute);

	List<Candidate> getCandidateByJobDescription(String jobdescription);

	List<Candidate> getCandidateBySkill(String skill);

	List<String> getAllCandidateEmpIds();

	boolean saveCandidate(Candidate candidate);

	boolean updateCandidate(Candidate candidate);

	boolean deleteCandidateById(String empId);

}