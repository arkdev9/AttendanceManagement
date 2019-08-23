package com.skilling.attendance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	@RequestMapping("/welcome")
	public String welcome() {
		return "index";
	}
}