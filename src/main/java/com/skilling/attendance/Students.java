package com.skilling.attendance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String branch;
	private Integer attendance;
	private String year;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setAttendance(Integer att) {
		this.attendance = att;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getBranch() {
		return this.branch;
	}

	public Integer getAttendance() {
		return this.attendance;
	}

	public String getYear() {
		return this.year;
	}

}