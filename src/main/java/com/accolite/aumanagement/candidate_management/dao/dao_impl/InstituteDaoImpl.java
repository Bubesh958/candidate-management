package com.accolite.aumanagement.candidate_management.dao.dao_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.aumanagement.candidate_management.dao.InstituteDao;
import com.accolite.aumanagement.candidate_management.model.Institute;
import com.accolite.aumanagement.candidate_management.model.mapper.InstituteRowMappper;

@Repository
public class InstituteDaoImpl implements InstituteDao 
{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Institute> getAllInstitutes()
	{
		try {
			return jdbcTemplate.query("select * from institutes", new InstituteRowMappper());
		} catch (DataAccessException e) {
			return null;
		}
	}

}
