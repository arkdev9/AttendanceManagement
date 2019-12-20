package com.skilling.attendance.forms;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RegisterForm {

	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String description;
	private ArrayList<String> students = new ArrayList<String>();

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<String> getStudents() {
		return this.students;
	}

	public void setStudents(ArrayList<String> students) {
		this.students = students;
	}

}