package com.project.insurance.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.exception.ClientSessionExpiredException;
import com.project.insurance.model.Client;

@Controller
public class ClientInfoController {
	// 회원의 정보를 확인하는 화면의 컨트롤러, 회원 탈퇴, 정보 수정등이 가능
	@RequestMapping(value = "client/info", method = RequestMethod.GET)
	public String clientInfo(Model model, HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("client");
		if(client == null) throw new ClientSessionExpiredException();
		
		model.addAttribute("clientInfo", client);
		return "clientInfo";
	}

}
