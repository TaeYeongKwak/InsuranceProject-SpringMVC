package com.project.insurance.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.model.Client;
import com.project.insurance.service.ClientService;

@Controller
public class ClientInfoController {
	@Autowired
	private ClientService clientService;
	
	 @RequestMapping(value="client/Info", method=RequestMethod.POST)
	    public Object clientInfo(Client client, Model model, HttpServletRequest request) throws SQLException {
		 	HttpSession session = request.getSession();
			Client Cresult = clientService.login(client.getId(), client.getPassword());
			session.setAttribute("id", Cresult);
			
			if (Cresult != null) {
				return "home";
			} 
			
			else {
				
				return session.getAttribute("id");
			}

		
	    }
}
