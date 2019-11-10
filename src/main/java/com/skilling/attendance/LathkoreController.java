package com.skilling.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LathkoreController {

	@Autowired
	private StudentsRepository studentsRepository;

	@PostMapping(path = "/add")
	public String customerInformation(Students student) {
		studentsRepository.save(student);
		return "Saved";
	}
}