package com.project.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.model.Client;
import com.project.insurance.model.manager.Manager;
import com.project.insurance.service.ClientService;
import com.project.insurance.service.ManagerService;

@Controller
public class SignUpController {
	@Autowired
	private ManagerService managerService;
	private ClientService clientService;
	
	@RequestMapping(value="ManagerRegist", method=RequestMethod.POST)
	public String ManagerRegist(Manager manager) {
		managerService.register(manager);
		return "login";
	}
	
	@RequestMapping(value="ClientRegist", method=RequestMethod.POST)
	public String ClientRegist(Client client) {
		clientService.register(client);
		return "login";
	}
	
	
}

// 회원가입
//signUp.jsp 담당