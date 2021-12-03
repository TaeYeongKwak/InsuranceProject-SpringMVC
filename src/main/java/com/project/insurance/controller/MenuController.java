package com.project.insurance.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.exception.ClientSessionExpiredException;
import com.project.insurance.exception.ManagerSessionExpiredException;
import com.project.insurance.model.Client;
import com.project.insurance.model.Work;
import com.project.insurance.model.manager.Manager;
import com.project.insurance.type.ManagerType;
import com.project.insurance.type.WorkType;

@Controller
public class MenuController {
	// 관리자, 회원 메인 화면의 컨트롤러
	
	@RequestMapping(value = "manager/menu", method = RequestMethod.GET)
	public String managerMenu(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Manager mresult = (Manager) session.getAttribute("manager");
		if(mresult == null) throw new ManagerSessionExpiredException();
		
		ArrayList<Work> workList = this.workList(mresult.getJobPosition());
		model.addAttribute("manager", mresult);
		model.addAttribute("workList", workList);
		return "menu";
	}
	
	@RequestMapping(value = "client/menu", method = RequestMethod.GET)
	public String clientMenu(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Client cresult = (Client) session.getAttribute("client");
		if(cresult == null) throw new ClientSessionExpiredException();
		
		ArrayList<Work> workList = WorkType.CLIENT.getWorkList();
		model.addAttribute("client", cresult);
		model.addAttribute("workList", workList);
		return "menu";
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
