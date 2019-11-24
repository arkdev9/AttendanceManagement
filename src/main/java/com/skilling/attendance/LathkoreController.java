package com.skilling.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LathkoreController {

	@Autowired
	private StudentsRepository studentsRepository;

	@Autowired
	private EventsRepository eventsRepository;

	@PostMapping(path = "/add")
	public RedirectView addStudent(Students student) {
		studentsRepository.save(student);
		return new RedirectView("/add");
	}

	@PostMapping(path = "/add-event")
	public RedirectView addEvent(Events event) {
		eventsRepository.save(event);
		return new RedirectView("/add-event");
	}
}

