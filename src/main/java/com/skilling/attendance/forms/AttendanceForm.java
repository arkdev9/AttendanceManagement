package com.skilling.attendance.forms;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

public class AttendanceForm {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private ArrayList<String> students = new ArrayList<>();

	public Date getDate() {
		return this.date;
	}

	public ArrayList<String> getStudents() {
		return this.students;
	}

	public void setStudents(ArrayList<String> students) {
		this.students = students;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

