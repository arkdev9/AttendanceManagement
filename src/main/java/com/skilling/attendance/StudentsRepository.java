package com.skilling.attendance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

import com.skilling.attendance.Students;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StudentsRepository extends CrudRepository<Students, Integer> {

	@Query("SELECT s FROM Students s WHERE s.year=?1")
	public Collection<Students> findStudentsByYear(String year);

	@Query("SELECT s from Students s WHERE s.branch=?1")
	public Collection<Students> findStudentsByBranch(String branch);

}