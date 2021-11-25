package com.project.insurance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.exception.ManagerNotFoundException;
import com.project.insurance.model.Client;
import com.project.insurance.model.manager.Manager;
import com.project.insurance.service.ClientService;
import com.project.insurance.service.ManagerService;

@Controller
public class LoginController {

	@Autowired
	private ManagerService managerService;
	private ClientService clientService;

	@RequestMapping(value = "manager/signUp", method = RequestMethod.GET)
	public String ManagerSignUp(Model model) {
		model.addAttribute("isClient", null);
		return "signUp";
	}

	@RequestMapping(value = "client/signUp", method = RequestMethod.GET)
	public String ClientSignUp(Model model) {
		model.addAttribute("isClient", true);
		return "signUp";
	}

	@RequestMapping(value = "manager/login", method = RequestMethod.POST)
	public String ManagerLogin(Manager manager, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Manager Mresult = managerService.login(manager.getId(), manager.getPassword());

		if (Mresult == null)
			throw new ManagerNotFoundException();

		session.setAttribute("id", Mresult);
		model.addAttribute("Manager", manager);
		return "home";
		// id, password만 넘기기
	}

	@RequestMapping(value = "client/login", method = RequestMethod.POST)
	public String ClientLogin(Client client, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Client Cresult = clientService.login(client.getId(), client.getPassword());
		session.setAttribute("id", Cresult);

		if (Cresult != null) {
			model.addAttribute("Client", client);
			return "home";
		} else {
			return "login";
		}
		// id, password만 넘기기
	}

}