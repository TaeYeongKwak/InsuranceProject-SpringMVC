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
public class MedicalHistoryController {
	

	
	 @RequestMapping(value="mediclaHistory}", method=RequestMethod.GET)
	 public String  medicalHistory(Model model, HttpServletRequest request) throws SQLException  {
		 HttpSession session = request.getSession();
			Client client =(Client)session.getAttribute("id");
		 	model.addAttribute("medicalHistory", client.getMedicalHistory());
		 	
		 	return "medicalHistory";
			
	    }
	 @RequestMapping(value="medicalHistory/Modify", method=RequestMethod.POST)
	    public String medicalHistoryModify(Model model, HttpServletRequest request) throws SQLException  {
		 	HttpSession session = request.getSession();	
		 	Client client =(Client)session.getAttribute("id");
		 	model.addAttribute("medicalHistory", client.getMedicalHistory());
		 	
		 	return "medicalHistoryModify";
			}
}
