package com.project.insurance.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.model.manager.Manager;

@Controller
public class ManagerInfoController {
	@RequestMapping(value = "manager/Info", method = RequestMethod.GET)
	public String maanagerInfo(Model model, HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		Manager manager = (Manager) session.getAttribute("id");
		model.addAttribute("managerInfo", manager);

		return "managerInfo";
	}

	@RequestMapping(value = "manager/InfoModify", method = RequestMethod.GET)
	public String clientModifyInfo(Model model, HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		Manager manager = (Manager) session.getAttribute("id");
		model.addAttribute("managerInfo", manager);

		return "managerModifyInfo";
	}
}
