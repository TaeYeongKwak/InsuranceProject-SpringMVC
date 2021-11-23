package com.project.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.insurance.model.Client;
import com.project.insurance.model.manager.Manager;
import com.project.insurance.service.ClientService;
import com.project.insurance.service.ManagerService;

@Controller
public class SignUpController {
	@Autowired
	private ManagerService managerService;
	private ClientService clientService;

	@RequestMapping(value = "ManagerRegist", method = RequestMethod.POST)
	public String ManagerRegist(Manager manager) {
		managerService.register(manager);
		return "login";
	}

	@RequestMapping(value = "ClientRegist", method = RequestMethod.POST)
	public String ClientRegist(Client client) {
		clientService.register(client);
		return "login";
	}

	@ResponseBody
	@RequestMapping(value = "checkId", method = RequestMethod.GET)
	public String checkId(@RequestParam("mid")String managerID) {
		System.out.println(managerID + "SignUpCON");
		Manager manager = managerService.checkManagerID(managerID);
		if (manager == null) {
			return "1";
		} else {
			return "0";
		}
	}

}