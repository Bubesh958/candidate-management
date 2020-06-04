package com.accolite.aumanagement;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.accolite.aumanagement.candidate_management.dao.CandidateDao;
import com.accolite.aumanagement.candidate_management.dao.EmpSkillDao;
import com.accolite.aumanagement.candidate_management.dao.InstituteDao;
import com.accolite.aumanagement.candidate_management.dao.LocationDao;
import com.accolite.aumanagement.candidate_management.dao.SkillDao;
import com.accolite.aumanagement.candidate_management.model.Candidate;
import com.accolite.aumanagement.candidate_management.model.Institute;
import com.accolite.aumanagement.candidate_management.model.Location;
import com.accolite.aumanagement.candidate_management.model.Skill;
import com.accolite.aumanagement.candidate_management.service.CandidateService;
import com.accolite.aumanagement.candidate_management.service.InstituteService;
import com.accolite.aumanagement.candidate_management.service.LocationService;
import com.accolite.aumanagement.candidate_management.service.SkillService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.accolite.aumanagement.candidate_management.CandidateManagementApplication.class)
class CandidateManagementApplicationTests {

	@Autowired
	CandidateService candidateService;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	InstituteService instituteService;
	
	@MockBean
	CandidateDao candidateDao;
	
	@MockBean
	InstituteDao instituteDao;
	
	@MockBean
	LocationDao locationDao;
	
	@MockBean
	SkillDao skillDao;
	
	
	@Test
	void deleteCandidatByIdShouldReturnFalseWhenTheDataDoesNotExists()
	{
		when(candidateDao.deleteCandidateById("-1")).thenReturn(false);
		assertEquals(false, candidateService.deleteCandidateById("-1"));
	}
	
	@Test
	void deleteCandidateByIdShouldReturnTruWhenTheDateHasBeenDeleted()
	{
		when(candidateDao.deleteCandidateById("int375")).thenReturn(true);
		assertEquals(true, candidateService.deleteCandidateById("int375"));
	}
	
	@Test
	void getAllCandidateShouldReturnAllCandidates()
	{
		List<Skill> skills = new ArrayList<Skill>(Stream.of( new Skill(1,"java"), new Skill(2,"c++")).collect(Collectors.toList()));
		List<Candidate> candidates = new ArrayList<Candidate>(Stream.of(new Candidate("123","bubesh","p",1,"cit",skills,1,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),1,"intern","good","1234567890","hwalk958@gmail.com"), new Candidate("124","john","j",2,"mit",skills,2,"pune",new java.sql.Date(Calendar.getInstance().getTime().getTime()),2,"software Engineer","good","1245567890","john958@gmail.com")).collect(Collectors.toList()));
		when(candidateDao.getAllCandidate()).thenReturn(candidates);
		assertEquals(2, candidateService.getAllCandidate().size());
	}
	
	@Test
	void getAllCandidateEmpIdsShouldReturnAllCandidateEmpIds()
	{
		List<String> empIds = new ArrayList<String>(Stream.of("123","124").collect(Collectors.toList()));
		when(candidateDao.getAllCandidateEmpIds()).thenReturn(empIds);
		assertEquals(2, candidateService.getAllCandidateEmpIds().size());
	}
	
	@Test
	void getCandidateByEmpIdShouldReturnOneValueWhenItExists()
	{
		List<Skill> skills = new ArrayList<Skill>(Stream.of( new Skill(1,"java"), new Skill(2,"c++")).collect(Collectors.toList()));
		Candidate candidate = new Candidate("123","bubesh","p",1,"cit",skills,1,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),1,"intern","good","1234567890","hwalk958@gmail.com");
		when(candidateDao.getCandidateByEmpId("123")).thenReturn(Stream.of(candidate).collect(Collectors.toList()));
		assertEquals(1,candidateService.getCandidateByEmpId("123").size());
	}
	@Test
	void getCandidateByEmpIdShouldReturnEmptyListsWhenItDoesnotExists()
	{
		when(candidateDao.getCandidateByEmpId("125")).thenReturn(new ArrayList<>());
		assertEquals(0,candidateService.getCandidateByEmpId("125").size());
	}
	
	@Test
	void getCandidateByLocationShouldReturnAllCandidatesInThatLocation()
	{
		List<Skill> skills = new ArrayList<Skill>(Stream.of( new Skill(1,"java"), new Skill(2,"c++")).collect(Collectors.toList()));
		List<Candidate> candidates = new ArrayList<Candidate>(Stream.of(new Candidate("123","bubesh","p",1,"cit",skills,1,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),1,"intern","good","1234567890","hwalk958@gmail.com"), new Candidate("124","john","j",2,"mit",skills,2,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),2,"software Engineer","good","1245567890","john958@gmail.com")).collect(Collectors.toList()));
		when(candidateDao.getCandidateByLocation("bangalore")).thenReturn(candidates);
		assertTrue(1 < candidateService.getCandidateByLocation("bangalore").size());
	}
	
	@Test
	void getCandidateByLocationShouldReturnEmptyListsWhenItDoesnotExists()
	{
		when(candidateDao.getCandidateByLocation("sathy")).thenReturn(new ArrayList<>());
		assertEquals(0,candidateService.getCandidateByLocation("sathy").size());
	}
	
	@Test
	void getCandidateByInstituteShouldReturnAllCandidatesInThatInstitute()
	{
		List<Skill> skills = new ArrayList<Skill>(Stream.of( new Skill(1,"java"), new Skill(2,"c++")).collect(Collectors.toList()));
		List<Candidate> candidates = new ArrayList<Candidate>(Stream.of(new Candidate("123","bubesh","p",1,"cit",skills,1,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),1,"intern","good","1234567890","hwalk958@gmail.com"), new Candidate("124","john","j",2,"cit",skills,2,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),2,"software Engineer","good","1245567890","john958@gmail.com")).collect(Collectors.toList()));
		when(candidateDao.getCandidateByInstitute("cit")).thenReturn(candidates);
		assertTrue(1 < candidateService.getCandidateByInstitute("cit").size());
	}
	
	@Test
	void getCandidateByInstituteShouldReturnEmptyListsWhenItDoesnotExists()
	{
		when(candidateDao.getCandidateByInstitute("ait")).thenReturn(new ArrayList<>());
		assertEquals(0,candidateService.getCandidateByInstitute("ait").size());
	}
	
	@Test
	void getCandidateByJobDescriptionShouldReturnAllCandidatesInThatJobDescription()
	{
		List<Skill> skills = new ArrayList<Skill>(Stream.of( new Skill(1,"java"), new Skill(2,"c++")).collect(Collectors.toList()));
		List<Candidate> candidates = new ArrayList<Candidate>(Stream.of(new Candidate("123","bubesh","p",1,"cit",skills,1,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),1,"intern","good","1234567890","hwalk958@gmail.com"), new Candidate("124","john","j",2,"mit",skills,2,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),2,"intern","good","1245567890","john958@gmail.com")).collect(Collectors.toList()));
		when(candidateDao.getCandidateByJobDescription("intern")).thenReturn(candidates);
		assertTrue(1 < candidateService.getCandidateByJobDescription("intern").size());
	}
	
	@Test
	void getCandidateByJobDescriptionShouldReturnEmptyListsWhenItDoesnotExists()
	{
		when(candidateDao.getCandidateByLocation("analyst")).thenReturn(new ArrayList<>());
		assertEquals(0,candidateService.getCandidateByJobDescription("analyst").size());
	}
	
	@Test
	void getCandidateBySkillShouldReturnAllCandidatesInThatSkill()
	{
		List<Skill> skills = new ArrayList<Skill>(Stream.of( new Skill(1,"java"), new Skill(2,"java")).collect(Collectors.toList()));
		List<Candidate> candidates = new ArrayList<Candidate>(Stream.of(new Candidate("123","bubesh","p",1,"cit",skills,1,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),1,"intern","good","1234567890","hwalk958@gmail.com"), new Candidate("124","john","j",2,"mit",skills,2,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),2,"intern","good","1245567890","john958@gmail.com")).collect(Collectors.toList()));
		when(candidateDao.getCandidateBySkill("java")).thenReturn(candidates);
		assertTrue(1 < candidateService.getCandidateBySkill("java").size());
	}
	
	@Test
	void getCandidateBySkillShouldReturnEmptyListsWhenItDoesnotExists()
	{
		when(candidateDao.getCandidateBySkill("c")).thenReturn(new ArrayList<>());
		assertEquals(0,candidateService.getCandidateBySkill("c").size());
	}
	
	@Test
	void getAllInstitutesShouldReturnAllInstitutes()
	{
		List<Institute> institutes = new ArrayList<Institute>(Stream.of( new Institute(1,"cit"), new Institute(2,"mit")).collect(Collectors.toList()));
		when(instituteDao.getAllInstitutes()).thenReturn(institutes);
		assertTrue(1 < instituteService.getAllInstitutes().size());
	}
	
	@Test
	void getAllInstitutesShouldReturnEmptyListsWhenItDoesnotExists()
	{
		when(instituteDao.getAllInstitutes()).thenReturn(new ArrayList<>());
		assertEquals(0,instituteService.getAllInstitutes().size());
	}
	
	@Test
	void getAllLocationsShouldReturnAllLocations()
	{
		List<Location> institutes = new ArrayList<Location>(Stream.of( new Location(1,"pune"), new Location(2,"bangalore")).collect(Collectors.toList()));
		when(locationDao.getAllLocations()).thenReturn(institutes);
		assertTrue(1 < locationService.getAllLocations().size());
	}
	
	@Test
	void getAllLocationsShouldReturnEmptyListsWhenItDoesnotExists()
	{
		when(locationDao.getAllLocations()).thenReturn(new ArrayList<>());
		assertEquals(0,locationService.getAllLocations().size());
	}
	

	
	
	
	

}
