package com.accolite.aumanagement.candidate_management.model;

public class Location 
{
	private int locationid;
	private String location;
	
	public Location() {
		super();
	}
	
	
	public Location(int locationid, String location) {
		super();
		this.locationid = locationid;
		this.location = location;
	}


	public int getLocationid() {
		return locationid;
	}


	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
