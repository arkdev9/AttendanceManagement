package com.skilling.attendance.controllers;

import com.skilling.attendance.forms.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Collection;

import com.skilling.attendance.models.*;

@RestController
public class LathkoreController {

	private StudentRepository studentRepository;
	private OrganisingRepository organisingRepository;
	private AttendanceRepository attendanceRepository;
	private EventRepository eventRepository;

	@Autowired
	public LathkoreController(StudentRepository studentRepository, OrganisingRepository organisingRepository, AttendanceRepository attendanceRepository, EventRepository eventRepository) {
		this.eventRepository = eventRepository;
		this.organisingRepository = organisingRepository;
		this.studentRepository = studentRepository;
		this.attendanceRepository = attendanceRepository;
	}

	@PostMapping(path = "/add")
	public RedirectView addStudent(Student student) {
		studentRepository.save(student);
		return new RedirectView("/add");
	}

	@PostMapping(path = "/add-event")
	public RedirectView addEvent(Event event) {
		eventRepository.save(event);
		return new RedirectView("/add-event");
	}

	@PostMapping(path = "/event/take-attendance/{id}")
	public RedirectView takeAttendance(RegisterForm attendanceForm) {

		return new RedirectView("/");
	}

	@PostMapping(path = "/modify-event/{eventId}")
	public RedirectView modifyEvent(@PathVariable("eventId") Integer eventId, RegisterForm form) {
		System.out.println(form.getName());
		ArrayList<String> rollNumbers = form.getStudents();
		Collection<Organising> existingOrganisers = organisingRepository.getEventOrganisers(eventId);
		// First add the ones that aren't part of the team
		for (String roll : rollNumbers) {
			// Check if this roll number is in existing
			boolean found = false;
			for (Organising record : existingOrganisers) {
				if (record.getRoll().equals(roll)) {
					found = true;
					break;
				}
			}
			if (!found) {
				organisingRepository.save(new Organising(eventId, roll));
				System.out.println("Added: " + roll);
			}
		}
		// Delete the ones that aren't in the received list
		for (Organising record : existingOrganisers) {
			boolean found = false;
			for (String roll : rollNumbers) {
				// if record.roll not in rollNumbers, remove
				if (record.getRoll().equals(roll)) {
					found = true;
					break;
				}
			}
			if (!found) {
				organisingRepository.deleteById(record.getId());
				System.out.println("Removed: " + record.getRoll());
			}
		}
		return new RedirectView("/");
	}

}
