package com.accolite.aumanagement.candidate_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.candidate_management.dao.SkillDao;
import com.accolite.aumanagement.candidate_management.dao.dao_impl.TrendDaoImpl;
import com.accolite.aumanagement.candidate_management.model.Skill;
import com.accolite.aumanagement.candidate_management.model.Trend;

@CrossOrigin
@RestController
@RequestMapping("/trend")
public class TrendController 
{
	@Autowired
	TrendDaoImpl trendDao;
	
	@GetMapping("/skills")
	public ResponseEntity<?> getSkillsCount()
	{
		List<Trend> trends = null;
		trends = trendDao.getSkillsCount();
		if(trends.isEmpty())
			return new ResponseEntity<String>("Empty",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Trend>>(trends,HttpStatus.OK);
	}
	
	@GetMapping("/institutes")
	public ResponseEntity<?> getInstituesCount()
	{
		List<Trend> trends = null;
		trends = trendDao.getInstitutesCount();
		if(trends.isEmpty())
			return new ResponseEntity<String>("Empty",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Trend>>(trends,HttpStatus.OK);
	}
	
	@GetMapping("/locations")
	public ResponseEntity<?> getLocationsCount()
	{
		List<Trend> trends = null;
		trends = trendDao.getLocationsCount();
		if(trends.isEmpty())
			return new ResponseEntity<String>("Empty",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Trend>>(trends,HttpStatus.OK);
	}
}
