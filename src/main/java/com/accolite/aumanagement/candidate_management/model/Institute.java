package com.accolite.aumanagement.candidate_management.model;

public class Institute 
{
	private int instituteid;
	private String institute;
	
	public Institute() {
		super();
	}

	public Institute(int instituteid, String institute) {
		super();
		this.instituteid = instituteid;
		this.institute = institute;
	}

	public int getInstituteid() {
		return instituteid;
	}

	public void setInstituteid(int instituteid) {
		this.instituteid = instituteid;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}
	
	
}

