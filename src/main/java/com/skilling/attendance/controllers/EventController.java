package com.skilling.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilling.attendance.models.*;

import java.util.Collection;

@Controller
public class EventController {
	
	private StudentRepository studentRepository;
	private EventRepository eventRepository;
	private AttendanceRepository attendanceRepository;
	private OrganisingRepository organisingRepository;
	
	public EventController(EventRepository eventRepository, StudentRepository studentRepository, AttendanceRepository attendanceRepository, OrganisingRepository organisingRepository) {
		this.studentRepository = studentRepository;
		this.eventRepository = eventRepository;
		this.attendanceRepository = attendanceRepository;
		this.organisingRepository = organisingRepository;
	}
	
	@RequestMapping(value = "/event/add", method = RequestMethod.GET)
	public String addEvent() {
		return "add-event";
	}
	
	@RequestMapping(value = "/event/details/{id}", method = RequestMethod.GET)
	public String event(@PathVariable("id") int id, Model model) {
		eventRepository.findById(id).ifPresent(o -> model.addAttribute("event", o));
		model.addAttribute("students", studentRepository.findAll());
		
		return "event";
	}
	
	@RequestMapping("/events")
	public String events(Model model) {
		Iterable<Event> events = eventRepository.findAll();
		model.addAttribute("events", events);
		return "events";
	}
	
	@RequestMapping("/event/take-attendance/{eventId}")
	public String takeAttendance(Model model, @PathVariable String eventId) {
		Collection<String> rollNumbers = organisingRepository.getEventOrganisersRollNumbers(Integer.parseInt(eventId));
		Event event = eventRepository.getEventById(Integer.parseInt(eventId));
		model.addAttribute("rollNumbers", rollNumbers);
		model.addAttribute("event", event);
		return "take-attendance";
	}
	
}