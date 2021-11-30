package com.project.insurance.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.insurance.exception.AccidentNotFoundException;

@ControllerAdvice
public class InsuranceProductExceptionAdvice {
	
	@ExceptionHandler(AccidentNotFoundException.class)
	public String accidentNotFound(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("message", "해당 보험이 존재하지 않습니다.");
		if(session.getAttribute("manager") != null)
			model.addAttribute("resultPage", "manager/menu");
		else
			model.addAttribute("resultPage", "client/menu");
		return "message";
	}
	
}
