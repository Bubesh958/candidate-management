package com.accolite.aumanagement.candidate_management.integration_testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.aumanagement.candidate_management.CandidateManagementApplication;
import com.accolite.aumanagement.candidate_management.model.Candidate;
import com.accolite.aumanagement.candidate_management.model.Institute;
import com.accolite.aumanagement.candidate_management.model.JobDescription;
import com.accolite.aumanagement.candidate_management.model.Location;
import com.accolite.aumanagement.candidate_management.model.Skill;


@SpringBootTest(classes = CandidateManagementApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class IntegrationTesting 
{ 
	@LocalServerPort
    private int port;
 
    @Autowired
    private TestRestTemplate restTemplate;
	
    @Test
    public void getAllCandidatesShouldReturnAllAvailableCandidates() 
    {
        ResponseEntity<Candidate[]> res= this.restTemplate. getForEntity("http://localhost:" + port + "/candidates",Candidate[].class);
        assertTrue(0 < res.getBody().length);
    }
    
    @Test
    public void getAllCandidatesShouldReturnHttpStatusOkWhenThereIsData() 
    {
        ResponseEntity<Candidate[]> res= this.restTemplate. getForEntity("http://localhost:" + port + "/candidates",Candidate[].class);
        assertEquals(HttpStatus.OK,res.getStatusCode());
    }
    
    
    @Test
    public void getAllSkillsShouldReturnAllAvailableSkills() 
    {
        ResponseEntity<Skill[]> res= this.restTemplate. getForEntity("http://localhost:" + port + "/skills",Skill[].class);
        assertTrue(0 < res.getBody().length);
    }
    
    @Test
    public void getAllSkillsShouldReturnHttpStatusOkWhenThereIsData() 
    {
        ResponseEntity<Skill[]> res= this.restTemplate. getForEntity("http://localhost:" + port + "/skills",Skill[].class);
        assertEquals(HttpStatus.OK,res.getStatusCode());
    }
    
    
    
    @Test
    public void getAllLocationsShouldReturnAllAvailableLocations() 
    {
        ResponseEntity<Location[]> res= this.restTemplate. getForEntity("http://localhost:" + port + "/locations",Location[].class);
        assertTrue(0 < res.getBody().length);
    }
    
    @Test
    public void getAllLocationsShouldReturnHttpStatusOkWhenThereIsData() 
    {
        ResponseEntity<Location[]> res= this.restTemplate. getForEntity("http://localhost:" + port + "/locations",Location[].class);
        assertEquals(HttpStatus.OK,res.getStatusCode());
    }
    
    @Test
    public void getAllInstitutesShouldReturnAllAvailableInstitutes() 
    {
        ResponseEntity<Institute[]> res= this.restTemplate. getForEntity("http://localhost:" + port + "/institutes",Institute[].class);
        assertTrue(0 < res.getBody().length);
    }
    
    @Test
    public void getAllInstitutesShouldReturnHttpStatusOkWhenThereIsData() 
    {
        ResponseEntity<Institute[]> res= this.restTemplate. getForEntity("http://localhost:" + port + "/institutes",Institute[].class);
        assertEquals(HttpStatus.OK,res.getStatusCode());
    }
    
    @Test
    public void getAllJobDescriptionsShouldReturnAllAvailableJobDescriptions() 
    {
        ResponseEntity<JobDescription[]> res= this.restTemplate. getForEntity("http://localhost:" + port + "/jobdescriptions",JobDescription[].class);
        assertTrue(0 < res.getBody().length);
    }
    
    @Test
    public void getAllJobDescriptionsShouldReturnHttpStatusOkWhenThereIsData() 
    {
        ResponseEntity<JobDescription[]> res= this.restTemplate. getForEntity("http://localhost:" + port + "/jobdescriptions",JobDescription[].class);
        assertEquals(HttpStatus.OK,res.getStatusCode());
    }
    

    

    
    
    
}

