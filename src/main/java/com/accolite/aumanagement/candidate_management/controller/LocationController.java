package com.accolite.aumanagement.candidate_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.aumanagement.candidate_management.model.JobDescription;
import com.accolite.aumanagement.candidate_management.model.Location;
import com.accolite.aumanagement.candidate_management.repository.LocationRepository;

@CrossOrigin
@RestController
@RequestMapping("/locations")
public class LocationController 
{
	@Autowired
	LocationRepository locationRepository;
	

	@GetMapping
	public ResponseEntity<?> getAllLocations()
	{
		List<Location> locations = null;
		locations = locationRepository.getAllLocations();
		if(locations.isEmpty())
			return new ResponseEntity<String>("Empty",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Location>>(locations,HttpStatus.OK);
	}
	
}
