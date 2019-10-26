package com.skilling.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

	@Autowired
	private StudentsRepository studentsRepository;

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
	public String addStudentToRegister() {
		return new String("add");
	}

	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}

	@RequestMapping("/events")
	public String events() {
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