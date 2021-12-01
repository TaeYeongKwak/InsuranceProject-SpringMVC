package com.project.insurance.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.insurance.exception.InsuranceDataAccessException;
import com.project.insurance.exception.InsuranceNotFoundException;

@ControllerAdvice
public class InsuranceProductExceptionAdvice {
	
	@ExceptionHandler(InsuranceNotFoundException.class)
	public String insuranceNotFound(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("message", "해당 보험이 존재하지 않습니다.");
		if(session.getAttribute("manager") != null)
			model.addAttribute("resultPage", "manager/menu");
		else
			model.addAttribute("resultPage", "client/menu");
		return "message";
	}
	
	@ExceptionHandler(InsuranceDataAccessException.class)
	public String insuranceDataAccess(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("message", "보험에 접근하는 도중에 오류가 발생하였습니다.");
		if(session.getAttribute("manager") != null)
			model.addAttribute("resultPage", "manager/menu");
		else
			model.addAttribute("resultPage", "client/menu");
		return "message";
	}
	
}
