package com.project.insurance.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.exception.ManagerNotFoundException;
import com.project.insurance.model.Client;
import com.project.insurance.model.Work;
import com.project.insurance.model.manager.Manager;
import com.project.insurance.service.ClientService;
import com.project.insurance.service.ManagerService;
import com.project.insurance.type.ManagerType;
import com.project.insurance.type.WorkType;

@Controller
public class LoginController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "manager/signUp", method = RequestMethod.GET)
	public String managerSignUp(Model model) {
		model.addAttribute("isClient", null);
		return "signUp";
	}

	@RequestMapping(value = "client/signUp", method = RequestMethod.GET)
	public String clientSignUp(Model model) {
		model.addAttribute("isClient", true);
		return "signUp";
	}

	@RequestMapping(value = "manager/login", method = RequestMethod.POST)
	public String ManagerLogin(Manager manager, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("client", null);
		Manager mresult = managerService.login(manager.getId(), manager.getPassword());
		if (mresult == null) 
			throw new ManagerNotFoundException();
		
		ArrayList<Work> workList = this.workList(mresult.getJobPosition());
		session.setAttribute("manager", mresult);
		
		model.addAttribute("manager", mresult);
		model.addAttribute("workList", workList);
		return "menu";
		// id, password만 넘기기
	}

	@RequestMapping(value = "client/login", method = RequestMethod.POST)
	public String ClientLogin(Client client, Model model, HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		session.setAttribute("manager", null);
		Client cresult = clientService.login(client.getId(), client.getPassword());
		
		if (cresult != null) {
			ArrayList<Work> workList = WorkType.CLIENT.getWorkList();
			
			session.setAttribute("client", cresult);
			model.addAttribute("client", cresult);
			model.addAttribute("workList", workList);
			return "menu";
		} else {
			return "login";
		}
		// id, password만 넘기기
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("manager", null);
		session.setAttribute("client", null);
		model.addAttribute("message", "로그아웃을 완료하였습니다.");
		model.addAttribute("resultPage", "/");
		return "message";
	}

	private ArrayList<Work> workList(ManagerType jobPosition) {
		switch (jobPosition) {
		case IP:
			return WorkType.IP.getWorkList();
		case IPA:
			return WorkType.IPA.getWorkList();
		case UW:
			return WorkType.UW.getWorkList();
		case CM:
			return WorkType.CM.getWorkList();
		case CH:
			return WorkType.CH.getWorkList();
		case SP:
			return WorkType.SP.getWorkList();
		}
		return null;
	}

}