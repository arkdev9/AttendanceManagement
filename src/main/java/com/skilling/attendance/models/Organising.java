package com.skilling.attendance.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Organising {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer eventId;
	private String roll;

	public Organising() {}

	public Organising(int eventId, String roll) {
		this.eventId = eventId;
		this.roll = roll;
	}
	public Integer getId() { return this.id; }
	public Integer getEventId() { return this.eventId; }
	public String getRoll() { return this.roll; }

	public void setId(Integer id) { this.id = id; }
	public void setEventId(Integer eventId) { this.eventId = eventId; }
	public void setRoll(String roll) { this.roll = roll; }
	
}