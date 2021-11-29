package com.project.insurance.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.insurance.exception.ContractNotFoundException;

@ControllerAdvice
public class ContractExceptionAdvice {
	
	@ExceptionHandler(ContractNotFoundException.class)
	public String contractException(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("message", "해당 계약이 존재하지 않습니다.");
		if(session.getAttribute("manager") != null)
			model.addAttribute("resultPage", "manager/menu");
		else
			model.addAttribute("resultPage", "client/menu");
		return "message";
	}
	
}
