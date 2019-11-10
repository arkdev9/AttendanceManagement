package com.skilling.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;

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

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "add";
	}

	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}

	@RequestMapping("/events")
	public String events(Model model) {
		model.addAttribute("events", eventsRepository.getAllEvents());
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