package com.skilling.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

import com.skilling.attendance.StudentsRepository;

@Controller
public class ViewController {

	@Autowired
	private StudentsRepository studentsRepository;

	@RequestMapping("/welcome")
	public String welcome() {
		return "index";
	}

	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("thirdStudents", viewAllStudents("1"));
		model.addAttribute("secondStudents", viewAllStudents("2"));
		model.addAttribute("thirdStudents", viewAllStudents("3"));
		return "view";
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addStudentToRegister() {
		return new String("add");
	}

	@RequestMapping("/get-branch/{year}")
	public @ResponseBody Iterable<Students> viewAllStudents(@PathVariable String year) {
		Iterable<Students> all = studentsRepository.findAll();
		ArrayList<Students> payload = new ArrayList<Students>();

		for (Students student : all) {
			if (year.equals(student.getYear())) {
				payload.add(student);
			}
		}

		return payload;
	}
}