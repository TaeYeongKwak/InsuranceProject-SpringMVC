package com.project.insurance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		return "signUp";
	}
	
	@RequestMapping(value = "/developedInsuranceList", method = RequestMethod.GET)
	public String developedInsuranceList() {
		return "developedInsuranceList";
	}
	
	
//	@RequestMapping(value = "test1", method = RequestMethod.POST)
//	public String test1(Client client, Model model) {
//		model.addAttribute("client", client);
//		return "home";
//	}
//	
//	@RequestMapping(value = "test2", method = RequestMethod.POST)
//	public String test2(Manager manager, Model model) {
//		model.addAttribute("manager", manager);
//		return "home";
//	}
	
}