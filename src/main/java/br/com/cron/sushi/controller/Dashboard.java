package br.com.cron.sushi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Dashboard {

	@GetMapping("/")
	private String home() {
		return "index";
	}
	

}
