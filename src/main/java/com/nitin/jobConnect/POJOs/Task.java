package com.nitin.jobConnect.POJOs;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long taskId;
	private String Date;
	private String Time;
	private String TaskName;
	private String TaskDesc;
	private boolean isCompleted;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
	private Profiles profile;

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getTaskName() {
		return TaskName;
	}

	public void setTaskName(String taskName) {
		TaskName = taskName;
	}

	public String getTaskDesc() {
		return TaskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		TaskDesc = taskDesc;
	}

	public Profiles getProfile() {
		return profile;
	}

	public void setProfile(Profiles profile) {
		this.profile = profile;
	}

	public Task() {
		super();
	}

	public Task(long taskId, String date, String time, String taskName, String taskDesc, boolean isCompleted,
			Profiles profile) {
		super();
		this.taskId = taskId;
		Date = date;
		Time = time;
		TaskName = taskName;
		TaskDesc = taskDesc;
		this.isCompleted = isCompleted;
		this.profile = profile;
	}

	
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", Date=" + Date + ", Time=" + Time + ", TaskName=" + TaskName + ", TaskDesc="
				+ TaskDesc + ", isCompleted=" + isCompleted + ", profile=" + profile + "]";
	}
	
	
	public Task(String id, String id2, String id3, String id4, boolean b, Profiles profile2) {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
