package com.project.insurance.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.insurance.exception.DuplicateClientIdException;
import com.project.insurance.exception.DuplicateManagerIdException;
import com.project.insurance.exception.ManagerDataAccessException;
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
	public String ManagerRegist(Model model, Manager manager) {
		try {
			model.addAttribute("message", managerService.register(manager) ? "회원등록이 성공하였습니다." : "회원등록에 실패하였습니다.");
			model.addAttribute("resultPage", "/");
		} catch (SQLException e) {
			throw new ManagerDataAccessException();
		} catch (DuplicateKeyException e) {
			throw new DuplicateManagerIdException();
		}
		return "message";
	}

	@RequestMapping(value = "client/regist", method = RequestMethod.POST)
	public String ClientRegist(Model model, Client client) {
		try {
			model.addAttribute("message", clientService.register(client) ? "회원등록이 성공하였습니다." : "회원등록에 실패하였습니다.");
			model.addAttribute("resultPage", "/");
		} catch (SQLException e) {
			throw new ManagerDataAccessException();
		} catch (DuplicateKeyException e) {
			throw new DuplicateClientIdException();
		}
		return "message";
	}

	@ResponseBody
	@RequestMapping(value = "manager/checkId", method = RequestMethod.GET)
	public String checkmId(@RequestParam("mid") String managerID) {
		try {
			Manager manager = managerService.checkManagerID(managerID);
			if (manager == null)
				return "1"; 
		} catch (SQLException e) {
			throw new ManagerDataAccessException();
		}
		return "0";
	}

	@ResponseBody
	@RequestMapping(value = "client/checkId", method = RequestMethod.GET)
	public String checkcId(@RequestParam("cid") String clientID) {
		try {
			Client client = clientService.checkClientID(clientID);
			if (client == null)
				return "1";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";
	}

}