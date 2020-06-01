package com.accolite.aumanagement.candidate_management.dao;

import java.util.List;

import com.accolite.aumanagement.candidate_management.model.EmpSkill;

public interface EmpSkillDao {

	List<EmpSkill> getEmpSkills();

	boolean saveEmpSkill(List<EmpSkill> empSkills);

	boolean deleteEmpSkillById(String empid);

}