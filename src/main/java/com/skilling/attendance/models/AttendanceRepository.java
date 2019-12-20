package com.skilling.attendance.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

// CRUD refers Create, Read, Update, Delete

public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {

	@Query("SELECT a FROM Attendance a WHERE a.eventId=?1")
	public Collection<Attendance> getEventAttendance(Integer eventId);

	@Query("SELECT a FROM Attendance a WHERE a.roll=?1")
	public Collection<Attendance> getStudentAttendance(String roll);

}