package com.skilling.attendance.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

// CRUD refers Create, Read, Update, Delete

public interface EventRepository extends CrudRepository<Event, Integer> {

	@Query("SELECT e FROM Event e WHERE e.id=?1")
	public Event getEventById(Integer id);

}