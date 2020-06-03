package com.accolite.aumanagement.candidate_management.service;

import java.util.List;

import com.accolite.aumanagement.candidate_management.model.EmpSkill;

public interface EmpSkillService {

	List<EmpSkill> getEmpSkills();

	boolean saveEmpSkill(List<EmpSkill> empSkills);

	boolean deleteEmpSkillById(String empid);

}