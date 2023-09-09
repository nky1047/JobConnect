package com.nitin.jobConnect.POJOs;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="profiles")
public class Profiles {
	private String name;
	private String currentCompany;
	private String yoe;
	private String skills[];
	private String designation;
	
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrentCompany() {
		return currentCompany;
	}
	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}
	public String getYoe() {
		return yoe;
	}
	public void setYoe(String yoe) {
		this.yoe = yoe;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public Profiles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
