package com.skilling.attendance.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // This tells Hibernate to make a table out of this class
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer eventId;
	private String roll;
	private Boolean attended;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	public Integer getId() { return this.id; }
	public Integer getEventId() { return this.eventId; }
	public String getRoll() { return this.roll; }
	public Boolean getAttended() { return this.attended; }
	public Date getDate() { return this.date; }

	public void setId(Integer id) { this.id = id; }
	public void setEventId(Integer eventId) { this.eventId = eventId; }
	public void setRoll(String roll) { this.roll = roll; }
	public void setAttended(Boolean attended) { this.attended = attended; }
	public void setDate(Date date) { this.date = date; }
	
}