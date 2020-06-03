package com.accolite.aumanagement.candidate_management.model;

import java.sql.Date;

public class Trend 
{
	private int count;
	private String label;
	
	public Trend() {
		super();
	}

	public Trend(int count, String label) {
		super();
		this.count = count;
		this.label = label;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	

}
