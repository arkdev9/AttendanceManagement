package com.skilling.attendance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

import com.skilling.attendance.Events;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EventsRepository extends CrudRepository<Events, Integer> {

	@Query("SELECT s FROM Events s")
	public Collection<Events> getAllEvents();

	@Query("SELECT e FROM Events e WHERE e.name=?1")
	public Collection<Events> getEventOrganisers(String name);

}