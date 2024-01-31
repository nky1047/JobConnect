package com.nitin.jobConnect.POJOs;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Profiles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long JBid;
	
	@Column(name = "name")
	private String name;
	private String currentCompany;
	private String yoe;

	private String designation;

//	 @OneToMany(mappedBy = "task")
//	    List<Task> tasksList = new ArrayList<>();

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profile", cascade = CascadeType.ALL)
	private List<Task> tasksList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profile", cascade = CascadeType.ALL)
	private List<Skills> skillsList;

	public long getJBid() {
		return JBid;
	}

	public void setJBid(long jBid) {
		JBid = jBid;
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

	

	public Profiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Task> getTasksList() {
		return tasksList;
	}

	public void setTasksList(List<Task> tasksList) {
		this.tasksList = tasksList;
	}

	public Profiles(long jBid, String name, String currentCompany, String yoe, String designation, List<Task> tasksList,
			List<Skills> skillsList) {
		super();
		JBid = jBid;
		this.name = name;
		this.currentCompany = currentCompany;
		this.yoe = yoe;
		this.designation = designation;
		this.tasksList = tasksList;
		this.skillsList = skillsList;
	}

	public Profiles(long jBid2, String name2, String currentCompany2, String yoe2, List<Skills> skillsList2,
			String designation2, List<Task> tasksList2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Profiles [JBid=" + JBid + ", name=" + name + ", currentCompany=" + currentCompany + ", yoe=" + yoe
				+ ", designation=" + designation + ", tasksList=" + tasksList + ", skillsList=" + skillsList + "]";
	}

	public List<Skills> getSkillsList() {
		return skillsList;
	}

	public void setSkillsList(List<Skills> skillsList) {
		this.skillsList = skillsList;
	}
	
	
	
	

}
