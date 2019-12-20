package com.skilling.attendance.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

// CRUD refers Create, Read, Update, Delete

public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query("SELECT s FROM Student s WHERE s.year=?1")
	public Collection<Student> findStudentsByYear(String year);

	@Query("SELECT s from Student s WHERE s.branch=?1")
	public Collection<Student> findStudentsByBranch(String branch);

}