package com.accolite.aumanagement.candidate_management.model;

public class Skill 
{
	private int skillid;
	private String skill;
	
	public Skill()
	{
		
	}
	
	public Skill(int skillid, String skill) {
		super();
		this.skillid = skillid;
		this.skill = skill;
	}
	
	public int getSkillid() {
		return skillid;
	}
	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	

}
