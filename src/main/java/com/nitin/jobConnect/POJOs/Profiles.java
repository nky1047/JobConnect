package com.nitin.jobConnect.POJOs;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="profiles")
public class Profiles {
	private String jcId;
	private String name;
	private String currentCompany;
	private String yoe;
	private String skills[];
	private String designation;
	
	
	
	public String getJcId() {
		return jcId;
	}
	public void setJcId(String jcId) {
		this.jcId = jcId;
	}
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
	public Profiles(String jcId, String name, String currentCompany, String yoe, String[] skills, String designation) {
		super();
		this.jcId = jcId;
		this.name = name;
		this.currentCompany = currentCompany;
		this.yoe = yoe;
		this.skills = skills;
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Profiles [jcId=" + jcId + ", name=" + name + ", currentCompany=" + currentCompany + ", yoe=" + yoe
				+ ", skills=" + Arrays.toString(skills) + ", designation=" + designation + "]";
	}
	
	
	
}
