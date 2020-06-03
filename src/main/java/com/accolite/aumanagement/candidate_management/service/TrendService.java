package com.accolite.aumanagement.candidate_management.service;

import java.util.List;

import com.accolite.aumanagement.candidate_management.model.Trend;

public interface TrendService {

	List<Trend> getSkillsCount();

	List<Trend> getInstitutesCount();

	List<Trend> getLocationsCount();

}