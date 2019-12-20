package com.skilling.attendance.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

// CRUD refers Create, Read, Update, Delete

public interface OrganisingRepository extends CrudRepository<Organising, Integer> {
	
	@Query("SELECT a.roll FROM Organising a WHERE a.eventId=?1")
	public Collection<String> getEventOrganisersRollNumbers(Integer eventId);

	@Query("SELECT a FROM Organising a WHERE a.eventId=?1")
	public Collection<Organising> getEventOrganisers(Integer eventId);

	@Query("SELECT a FROM Organising a WHERE a.roll=?1")
	public Collection<Organising> getEventsByStudent(String roll);

}