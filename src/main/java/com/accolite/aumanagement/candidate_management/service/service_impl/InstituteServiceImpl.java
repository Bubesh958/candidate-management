package com.accolite.aumanagement.candidate_management.service.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.aumanagement.candidate_management.dao.InstituteDao;
import com.accolite.aumanagement.candidate_management.model.Institute;
import com.accolite.aumanagement.candidate_management.service.InstituteService;

@Service
public class InstituteServiceImpl implements InstituteService 
{
	@Autowired
	InstituteDao instituteDao;
	
	@Override
	public List<Institute> getAllInstitutes()
	{
		return instituteDao.getAllInstitutes();
	}

}
