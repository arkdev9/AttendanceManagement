package com.skilling.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilling.attendance.models.*;

import java.util.*;

@Controller
public class ViewController {

	StudentRepository studentRepository;
	EventRepository eventRepository;
	AttendanceRepository attendanceRepository;

	@Autowired
	public ViewController(EventRepository eventRepository, StudentRepository studentRepository, AttendanceRepository attendanceRepository) {
		this.eventRepository = eventRepository;
		this.studentRepository = studentRepository;
		this.attendanceRepository = attendanceRepository;
	}

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "add";
	}

	@RequestMapping("/view")
	public String view(Model model) {

		ArrayList<Date> dates = new ArrayList<>();
		HashMap<String, Collection<Attendance>> stuAttendance = getAttendanceByYear("2017");
		for (String key : stuAttendance.keySet()) {
			Collection<Attendance> attSet = stuAttendance.get(key);
			for (Attendance att : attSet) {
				dates.add(att.getDate());
			}
			break;
		}
		model.addAttribute("dates", dates);
		model.addAttribute("thirdStudents", getAttendanceByYear("2017"));

		return "view";
	}

	private HashMap<String, Collection<Attendance>> getAttendanceByYear(String year) {
		Collection<Student> thirdStudents = studentRepository.findStudentsByYear(year);
		HashMap<String, Collection<Attendance>> thirdStudentsAttendance = new HashMap<>();

		for (Student student : thirdStudents) {
			thirdStudentsAttendance.put(student.getRoll(), attendanceRepository.getStudentAttendance(student.getRoll()));
		}

		return thirdStudentsAttendance;

	}

}