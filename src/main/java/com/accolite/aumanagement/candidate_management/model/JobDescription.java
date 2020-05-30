package com.accolite.aumanagement.candidate_management.model;

public class JobDescription 
{
	private int jobdescriptionid;
	private String jobdescription;
	public JobDescription() {
		super();
	}
	public JobDescription(int jobdescriptionid, String jobdescription) {
		super();
		this.jobdescriptionid = jobdescriptionid;
		this.jobdescription = jobdescription;
	}
	public int getJobdescriptionid() {
		return jobdescriptionid;
	}
	public void setJobdescriptionid(int jobdescriptionid) {
		this.jobdescriptionid = jobdescriptionid;
	}
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
}
