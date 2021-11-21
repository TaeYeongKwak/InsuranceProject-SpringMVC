package com.project.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.model.Client;
import com.project.insurance.model.manager.Manager;
import com.project.insurance.service.ClientService;
import com.project.insurance.service.ManagerService;

@Controller
public class LoginController {

	@Autowired
	private ManagerService managerService;
	private ClientService clientService;

	@RequestMapping(value = "ManagerSginUp", method = RequestMethod.GET)
	public String ManagerSginUp(Model model) {
		model.addAttribute("isClient", null);
		return "signUp";
	}

	@RequestMapping(value = "ClientSginUp", method = RequestMethod.GET)
	public String ClientSginUp(Model model) {
		model.addAttribute("isClient", true);
		return "signUp";
	}

	@RequestMapping(value = "ManagerLogin", method = RequestMethod.POST)
	public String ManagerLogin(Manager manager, Model model) {
		Manager Mresult = managerService.login(manager.getId(), manager.getPassword());
		if (Mresult != null) {
			model.addAttribute("Manager", manager);
			return "home";
		} else {
			return "login";

		}
		// id, password만 넘기기
	}

	@RequestMapping(value = "ClientLogin", method = RequestMethod.POST)
	public String ClientLogin(Client client, Model model) {
		Client Cresult = clientService.login(client.getId(), client.getPassword());
		if (Cresult != null) {
			model.addAttribute("Client", client);
			return "home";
		} else {
			return "login";
		}
		// id, password만 넘기기
	}

}