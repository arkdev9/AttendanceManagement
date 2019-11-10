package com.skilling.attendance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Date date;
	private String organisers;

	public void setName(String name) {
		this.name = name;
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

}