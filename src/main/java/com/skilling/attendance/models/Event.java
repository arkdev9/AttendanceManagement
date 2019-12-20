package com.skilling.attendance.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // This tells Hibernate to make a table out of this class
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String description;
	private String organisers;

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void addOrganiser(String new_organiser) {
		this.organisers += "," + new_organiser + ",";
	}

	public void setOrganisers(List<String> organisers) {
		String parsed = "";
		for (String organiser : organisers) {
			parsed += organiser + ",";
		}

		this.organisers = parsed;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public List<String> getOrganisers() {
		List<String> parsed = new ArrayList<String>();
		for (String organiser : organisers.split(",")) {
			parsed.add(organiser);
		}

		return parsed;
	}

	public String getDescription() {
		return this.description;
	}

}