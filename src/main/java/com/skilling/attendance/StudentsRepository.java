package com.skilling.attendance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.skilling.attendance.Students;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StudentsRepository extends CrudRepository<Students, Integer> {
	// @Query("select * from students where branch=cse")
	// public List<Students> findStudentsByBranch(String branch);
}