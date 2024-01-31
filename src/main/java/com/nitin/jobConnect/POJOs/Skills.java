package com.nitin.jobConnect.POJOs;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Skills {
	@Id
	private String skillName;
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
	private Profiles profile;

	

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Skills(String skillName, Profiles profile) {
		super();
		this.skillName = skillName;
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Skills [skillName=" + skillName + ", profile=" + profile + "]";
	}

	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
