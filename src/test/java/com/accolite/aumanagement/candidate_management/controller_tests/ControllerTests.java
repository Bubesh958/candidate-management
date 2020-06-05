package com.accolite.aumanagement.candidate_management.controller_tests;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.aumanagement.candidate_management.CandidateManagementApplication;
import com.accolite.aumanagement.candidate_management.controller.CandidateController;
import com.accolite.aumanagement.candidate_management.controller.EmpSkillController;
import com.accolite.aumanagement.candidate_management.controller.InstituteController;
import com.accolite.aumanagement.candidate_management.controller.JobDescriptionController;
import com.accolite.aumanagement.candidate_management.controller.LocationController;
import com.accolite.aumanagement.candidate_management.controller.SkillController;
import com.accolite.aumanagement.candidate_management.controller.TrendController;
import com.accolite.aumanagement.candidate_management.model.Candidate;
import com.accolite.aumanagement.candidate_management.model.EmpSkill;
import com.accolite.aumanagement.candidate_management.model.Institute;
import com.accolite.aumanagement.candidate_management.model.JobDescription;
import com.accolite.aumanagement.candidate_management.model.Location;
import com.accolite.aumanagement.candidate_management.model.Skill;
import com.accolite.aumanagement.candidate_management.model.Trend;
import com.accolite.aumanagement.candidate_management.service.CandidateService;
import com.accolite.aumanagement.candidate_management.service.EmpSkillService;
import com.accolite.aumanagement.candidate_management.service.InstituteService;
import com.accolite.aumanagement.candidate_management.service.JobDescriptionService;
import com.accolite.aumanagement.candidate_management.service.LocationService;
import com.accolite.aumanagement.candidate_management.service.SkillService;
import com.accolite.aumanagement.candidate_management.service.TrendService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import io.opencensus.trace.Status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers= {CandidateController.class,EmpSkillController.class,InstituteController.class,JobDescriptionController.class,LocationController.class,SkillController.class,TrendController.class})
public class ControllerTests 
{
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	CandidateService candidateservice;
	
	@MockBean
	EmpSkillService empSkillService;

	
	@MockBean
	InstituteService instituteService;
	
	@MockBean
	JobDescriptionService jobdescriptionservice;
	
	@MockBean
	LocationService locationService;
	
	@MockBean
	SkillService skillService;
	
	@MockBean
	TrendService trendService;
	
	
	@Test
	public void getAllCandidatesShouldReturnAllCandidates() throws Exception
	{
		List<Skill> skills = new ArrayList<Skill>(Stream.of( new Skill(1,"java"), new Skill(2,"c++")).collect(Collectors.toList()));
		List<Candidate> candidates = new ArrayList<>();
		candidates.add(new Candidate("123","bubesh","p",1,"cit",skills,1,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),1,"intern","good","1234567890","hwalk958@gmail.com"));
		candidates.add(new Candidate("124","john","j",2,"mit",skills,2,"pune",new java.sql.Date(Calendar.getInstance().getTime().getTime()),2,"software Engineer","good","1245567890","john958@gmail.com"));
		when(candidateservice.getAllCandidate()).thenReturn(candidates);
		mvc.perform(get("/candidates"))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	
	
	@Test
	public void getAllEmpSkillsShouldReturnOkHttpStatus() throws Exception
	{
		List<EmpSkill> empSkills = new ArrayList<EmpSkill>(Stream.of( new EmpSkill("123",2), new EmpSkill("124",1)).collect(Collectors.toList()));
		when(empSkillService.getEmpSkills()).thenReturn(empSkills);
		mvc.perform(get("/empskills"))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void getAllInstitutesShouldReturnOkHttpStatus() throws Exception
	{
		List<Institute> institutes = new ArrayList<Institute>(Stream.of( new Institute(1,"cit"), new Institute(2,"mit")).collect(Collectors.toList()));
		when(instituteService.getAllInstitutes()).thenReturn(institutes);
		mvc.perform(get("/institutes"))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	
	@Test
	public void getAllLocationsShouldReturnOkHttpStatus() throws Exception
	{
		List<Location> locations = new ArrayList<Location>(Stream.of( new Location(1,"pune"), new Location(2,"bangalore")).collect(Collectors.toList()));
		when(locationService.getAllLocations()).thenReturn(locations);
		mvc.perform(get("/locations"))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void getAllSkillsShouldReturnOkHttpStatus() throws Exception
	{
		List<Skill> skills = new ArrayList<Skill>(Stream.of( new Skill(1,"java"), new Skill(2,"c++")).collect(Collectors.toList()));
		when(skillService.getSkills()).thenReturn(skills);
		mvc.perform(get("/skills"))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	

	@Test
	public void getAllJobDescriptionsShouldReturnOkHttpStatus() throws Exception
	{
		List<JobDescription> jobDescriptions = new ArrayList<JobDescription>(Stream.of( new JobDescription(1,"intern"), new JobDescription(2,"analyst")).collect(Collectors.toList()));
		when(jobdescriptionservice.getAllJobDescriptions()).thenReturn(jobDescriptions);
		mvc.perform(get("/jobdescriptions"))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void getSkillsCountShouldReturnOkHttpStatus() throws Exception
	{
		List<Trend> trends = new ArrayList<Trend>(Stream.of( new Trend(1,"java"), new Trend(2,"c++")).collect(Collectors.toList()));
		when(trendService.getSkillsCount()).thenReturn(trends);
		mvc.perform(get("/trend/skills"))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	
	@Test
	public void getInstituesCountShouldReturnOkHttpStatus() throws Exception
	{
		List<Trend> trends = new ArrayList<Trend>(Stream.of( new Trend(1,"cit"), new Trend(2,"mit")).collect(Collectors.toList()));
		when(trendService.getInstitutesCount()).thenReturn(trends);
		mvc.perform(get("/trend/institutes"))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void getLocationsCounttShouldReturnOkHttpStatus() throws Exception
	{
		List<Trend> trends = new ArrayList<Trend>(Stream.of( new Trend(1,"pune"), new Trend(2,"delhi")).collect(Collectors.toList()));
		when(trendService.getLocationsCount()).thenReturn(trends);
		mvc.perform(get("/trend/locations"))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	
	
	
	
	
	
//	public static String asJsonString(final Object obj) {
//    try {
//        final ObjectMapper mapper = new ObjectMapper();
//        final String jsonContent = mapper.writeValueAsString(obj);
//        return jsonContent;
//    } catch (Exception e) {
//        throw new RuntimeException(e);
//    }
//}  
	
	
	
	
	
//	@Test
//	public void createCandidateShouldReturnCreatedHttpStatus() throws Exception
//	{
//		List<Skill> skills = new ArrayList<Skill>(Stream.of( new Skill(1,"java"), new Skill(2,"c++")).collect(Collectors.toList()));
//		List<Candidate> candidates = new ArrayList<>();
//		candidates.add(new Candidate("123","bubesh","p",1,"cit",skills,1,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),1,"intern","good","1234567890","hwalk958@gmail.com"));
//		candidates.add(new Candidate("124","john","j",2,"mit",skills,2,"pune",new java.sql.Date(Calendar.getInstance().getTime().getTime()),2,"software Engineer","good","1245567890","john958@gmail.com"));
//		when(candidateservice.getAllCandidate()).thenReturn(candidates);
//		mvc.perform(post("/candidates")
//		   .content(asJsonString(new Candidate("123","bubesh","p",1,"cit",skills,1,"bangalore",new java.sql.Date(Calendar.getInstance().getTime().getTime()),1,"intern","good","1234567890","hwalk958@gmail.com"))))
//	       .andExpect(status().isCreated());
//	}
	
	
	
}







