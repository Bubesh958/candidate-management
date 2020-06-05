package com.accolite.aumanagement.candidate_management.service_tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.aumanagement.candidate_management.CandidateManagementApplication;
import com.accolite.aumanagement.candidate_management.dao.CandidateDao;
import com.accolite.aumanagement.candidate_management.dao.InstituteDao;
import com.accolite.aumanagement.candidate_management.dao.JobDescriptionDao;
import com.accolite.aumanagement.candidate_management.dao.LocationDao;
import com.accolite.aumanagement.candidate_management.dao.SkillDao;
import com.accolite.aumanagement.candidate_management.model.Candidate;
import com.accolite.aumanagement.candidate_management.model.Institute;
import com.accolite.aumanagement.candidate_management.model.JobDescription;
import com.accolite.aumanagement.candidate_management.model.Location;
import com.accolite.aumanagement.candidate_management.model.Skill;



@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class DaoTests 
{
		@Autowired
		CandidateDao candidateDao;
		
		@Autowired
		SkillDao skillDao;
		
		@Autowired
		LocationDao locationDao;
		
		@Autowired
		InstituteDao instituteDao; 
		
		@Autowired
		JobDescriptionDao jobDescriptionDao;
		
		@Test
		public void getAllCandidatesTest() {
			List<Candidate> candidates = candidateDao.getAllCandidate();
			assertThat(candidates).isNotNull();
		}
		
		@Test
		public void getAllSkillsTest() {
			List<Skill> skills = skillDao.getSkills();
			assertThat(skills).isNotNull();
		}
		
		@Test
		public void getAllLocationsTest()
		{
			List<Location> locations = locationDao.getAllLocations();
			assertThat(locations).isNotNull();
		}
		
		@Test
		public void getAllInstitutesTest()
		{
			List<Institute> institutes = instituteDao.getAllInstitutes();
			assertThat(institutes).isNotNull();
		}
		
		@Test
		public void getAllJobDescriptionsTest()
		{
			List<JobDescription> jobDescriptions = jobDescriptionDao.getAllJobDescriptions();
			assertThat(jobDescriptions).isNotNull();
		}
}
