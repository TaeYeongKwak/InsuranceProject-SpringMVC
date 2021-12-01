package com.project.insurance.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.insurance.exception.ContractDataAccessException;
import com.project.insurance.exception.ContractNotFoundException;
import com.project.insurance.exception.DuplicatePayMoneyException;

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
	
	@ExceptionHandler(DuplicatePayMoneyException.class)
	public String duplicatePayMoneyException(Model model) {
		model.addAttribute("message", "이미 해당 월 보험료 납입이 완료되었습니다.");
		model.addAttribute("resultPage", "client/menu");
		return "message";
	}
	
	@ExceptionHandler(ContractDataAccessException.class)
	public String contractDataAccess(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("message", "계약에 접근하는 도중 오류가 발생하였습니다.");
		if(session.getAttribute("manager") != null)
			model.addAttribute("resultPage", "manager/menu");
		else
			model.addAttribute("resultPage", "client/menu");
		return "message";
	}
	
}
