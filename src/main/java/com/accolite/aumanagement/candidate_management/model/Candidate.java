package com.accolite.aumanagement.candidate_management.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;

public class Candidate {

	private String empid;
	private String firstname;
	private String lastname;
	private int instituteid;
	private int locationid;
	private Date joiningdate;
	private int jobdescriptionid;
	private String feedback;
	private String contactnumber;
	private String email;
	
	
	public Candidate()
	{
		
	}
	
	public Candidate(String empid, String firstname, String lastname, int instituteid, int locationid, Date joiningdate,
			int jobdescriptionid, String feedback, String contactnumber, String email) {
		super();
		this.empid = empid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.instituteid = instituteid;
		this.locationid = locationid;
		this.joiningdate = joiningdate;
		this.jobdescriptionid = jobdescriptionid;
		this.feedback = feedback;
		this.contactnumber = contactnumber;
		this.email = email;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getInstituteid() {
		return instituteid;
	}

	public void setInstituteid(int instituteid) {
		this.instituteid = instituteid;
	}

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public int getJobdescription() {
		return jobdescriptionid;
	}

	public void setJobdescription(int jobdescriptionid) {
		this.jobdescriptionid = jobdescriptionid;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
	
}
