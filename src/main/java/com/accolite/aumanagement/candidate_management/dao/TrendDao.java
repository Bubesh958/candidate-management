package com.accolite.aumanagement.candidate_management.dao;

import java.util.List;

import com.accolite.aumanagement.candidate_management.model.Trend;

public interface TrendDao {

	List<Trend> getSkillsCount();

	List<Trend> getInstitutesCount();

	List<Trend> getLocationsCount();

}