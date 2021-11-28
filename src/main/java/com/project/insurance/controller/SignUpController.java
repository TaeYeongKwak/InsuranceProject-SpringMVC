package com.project.insurance.controller;

import java.sql.SQLException;

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
	// 회원가입
	// signUp.jsp 담당

	@Autowired
	private ManagerService managerService;
	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "manager/regist", method = RequestMethod.POST)
	public String ManagerRegist(Manager manager) {
		managerService.register(manager);
		return "login";
	}

	@RequestMapping(value = "client/regist", method = RequestMethod.POST)
	public String ClientRegist(Client client) throws SQLException {
		clientService.register(client);
		return "login";
	}

	@ResponseBody
	@RequestMapping(value = "manager/checkId", method = RequestMethod.GET)
	public String checkmId(@RequestParam("mid") String managerID) {
		System.out.println(managerID + "SignUpCON");
		Manager manager = managerService.checkManagerID(managerID);
		if (manager == null) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "client/checkId", method = RequestMethod.GET)
	public String checkcId(@RequestParam("cid") String clientID) {
		System.out.println(clientID + "SignUpCON");
		
		try {
	
			Client client = clientService.checkClientID(clientID);
			
			if (client == null) {
				return "1";
			} else {
				return "0";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}