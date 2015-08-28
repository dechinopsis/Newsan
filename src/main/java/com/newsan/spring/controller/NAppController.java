package com.newsan.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/app")
public class NAppController {
	@RequestMapping("/")
	public String start(Model model) {
		return "NApp";

	}
}
