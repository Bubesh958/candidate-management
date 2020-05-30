package com.accolite.aumanagement.candidate_management.model;

import java.sql.Date;
import java.util.List;

public class Candidate {

	private String empid;
	private String firstname;
	private String lastname;
	private int instituteid;
	private String institute;
	private List<Skill> skills;
	private int locationid;
	private String location;
	private Date joiningdate;
	private int jobdescriptionid;
	private String jobsdescription;
	private String feedback;
	private String contactnumber;
	private String email;
	
	public Candidate()
	{
		
	}

	public Candidate(String empid, String firstname, String lastname, int instituteid, String institute,
			List<Skill> skills, int locationid, String location, Date joiningdate, int jobdescriptionid,
			String jobsdescription, String feedback, String contactnumber, String email) {
		super();
		this.empid = empid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.instituteid = instituteid;
		this.institute = institute;
		this.skills = skills;
		this.locationid = locationid;
		this.location = location;
		this.joiningdate = joiningdate;
		this.jobdescriptionid = jobdescriptionid;
		this.jobsdescription = jobsdescription;
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


	public String getInstitute() {
		return institute;
	}


	public void setInstitute(String institute) {
		this.institute = institute;
	}


	public List<Skill> getSkills() {
		return skills;
	}


	public void setSkills(List<Skill> skills) {
		this.skills = skills;
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


	public Date getJoiningdate() {
		return joiningdate;
	}


	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}


	public int getJobdescriptionid() {
		return jobdescriptionid;
	}


	public void setJobdescriptionid(int jobdescriptionid) {
		this.jobdescriptionid = jobdescriptionid;
	}


	public String getJobsdescription() {
		return jobsdescription;
	}


	public void setJobsdescription(String jobsdescription) {
		this.jobsdescription = jobsdescription;
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

	@Override
	public String toString() {
		return "Candidate [empid=" + empid + ", firstname=" + firstname + ", lastname=" + lastname + ", instituteid="
				+ instituteid + ", institute=" + institute + ", skills=" + skills + ", locationid=" + locationid
				+ ", location=" + location + ", joiningdate=" + joiningdate + ", jobdescriptionid=" + jobdescriptionid
				+ ", jobsdescription=" + jobsdescription + ", feedback=" + feedback + ", contactnumber=" + contactnumber
				+ ", email=" + email + "]";
	}
	
	

	
	
}
