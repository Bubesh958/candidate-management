package com.accolite.aumanagement.candidate_management.model;


public class EmpSkill 
{
	private String empid;
	private int skillid;
	
	
	
	
	public EmpSkill() {
		super();
	}
	
	public EmpSkill(String empid, int skillid) {
		super();
		this.empid = empid;
		this.skillid = skillid;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public int getSkillid() {
		return skillid;
	}
	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}

	@Override
	public String toString() {
		return "EmpSkill [empid=" + empid + ", skillid=" + skillid + "]";
	}
	
}
