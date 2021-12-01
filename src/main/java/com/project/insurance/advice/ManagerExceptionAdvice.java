package com.project.insurance.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.insurance.exception.ManagerDataAccessException;
import com.project.insurance.exception.ManagerNotFoundException;

@ControllerAdvice
public class ManagerExceptionAdvice {

	@ExceptionHandler(ManagerNotFoundException.class)
	public String managerNotFoundException(Model model) {

		model.addAttribute("message", "해당 관리자가 존재하지 않습니다.");
		model.addAttribute("resultPage", "/");
		return "message";
	}
	
	@ExceptionHandler(ManagerDataAccessException.class)
	public String managerDataAccess(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("message", "관리자에 접근하는 도중 오류가 발생하였습니다.");
		if(session.getAttribute("manager") != null)
			model.addAttribute("resultPage", "manager/menu");
		else
			model.addAttribute("resultPage", "client/menu");
		return "message";
	}

}
