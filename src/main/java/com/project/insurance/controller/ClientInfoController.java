package com.project.insurance.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.model.Client;




@Controller
public class ClientInfoController {
	
	
	
	 @RequestMapping(value="client/Info", method=RequestMethod.POST)
	    public String clientInfo(Model model, HttpServletRequest request) throws SQLException  {
		 	HttpSession session = request.getSession();	
		 	Client client =(Client)session.getAttribute("id");
		 	model.addAttribute("clientInfo", client);
		 	
		 	return "clientInfo";
			}
	 
	 @RequestMapping(value="client/InfoModify", method=RequestMethod.POST)
	    public String clientModifyInfo(Model model, HttpServletRequest request) throws SQLException  {
		 	HttpSession session = request.getSession();	
		 	Client client =(Client)session.getAttribute("id");
		 	model.addAttribute("clientInfo", client);
		 	
		 	return "clientModifyInfo";
			}
}


