package com.skilling.attendance;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

	@Autowired
	private StudentsRepository studentsRepository;

	@Autowired
	EventsRepository eventsRepository;

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}

	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("thirdStudents", studentsRepository.findStudentsByYear("1"));
		model.addAttribute("secondStudents", studentsRepository.findStudentsByYear("2"));
		model.addAttribute("thirdStudents", studentsRepository.findStudentsByYear("3"));
		return "view";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("events", eventsRepository.findAll());
		return "register";
	}

	@RequestMapping(value = "/add-event", method = RequestMethod.GET)
	public String addEvent() {
		return "add-event";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "add";
	}

	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	public String event(@PathVariable("id") int id, Model model) {
		eventsRepository.findById(id).ifPresent(o -> model.addAttribute("event", o));
		return "event";
	}

	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}

	@RequestMapping("/events")
	public String events(Model model) {
		Iterable<Events> events = eventsRepository.findAll();
		model.addAttribute("events", events);
		return "events";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/update")
	public String update() {
		return "update";
	}

}