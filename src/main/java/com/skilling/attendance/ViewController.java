package com.skilling.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.skilling.attendance.StudentsRepository;

@Controller
public class ViewController {

	@Autowired
	private StudentsRepository studentsRepository;

	@RequestMapping("/welcome")
	public String welcome() {
		return "index";
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addStudentToRegister() {
		return new String("add");
	}

	@RequestMapping("/get-branch/{year}/{branch}")
	public @ResponseBody Iterable<Students> viewAllStudents(@PathVariable String year, @PathVariable String branch) {
		// studentsRepository.
	}
}