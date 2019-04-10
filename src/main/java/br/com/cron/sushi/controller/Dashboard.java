package br.com.cron.sushi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class Dashboard {

	@GetMapping("/")
	private String home() {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/login")
	private String login() {
		return "login";
	}
	

}
