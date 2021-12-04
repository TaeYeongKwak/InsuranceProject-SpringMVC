package com.project.insurance.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.insurance.exception.ClientDataAccessException;
import com.project.insurance.exception.ClientNotFoundException;
import com.project.insurance.exception.ClientSessionExpiredException;
import com.project.insurance.exception.DuplicateClientIdException;

@ControllerAdvice
public class ClientExceptionAdvice {
	
	@ExceptionHandler(ClientNotFoundException.class)
	public String clientNotFound(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("message", "해당 회원이 존재하지 않습니다.");
		if(session.getAttribute("manager") != null)
			model.addAttribute("resultPage", "manager/menu");
		else
			model.addAttribute("resultPage", "/");
		return "message";
	}
	
	@ExceptionHandler(ClientDataAccessException.class)
	public String clientDataAccess(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("message", "회원에 접근하는 도중 오류가 발생하였습니다.");
		if(session.getAttribute("manager") != null)
			model.addAttribute("resultPage", "manager/menu");
		else if(session.getAttribute("client") != null)
			model.addAttribute("resultPage", "client/menu");
		else
			model.addAttribute("resultPage", "/");
		return "message";
	}
	
	@ExceptionHandler(ClientSessionExpiredException.class)
	public String managerSessionExpired(Model model) {
		model.addAttribute("message", "회원 세션이 만료되었습니다.");
		model.addAttribute("resultPage", "/");
		return "message";
	}
	
	@ExceptionHandler(DuplicateClientIdException.class)
	public String duplicateManagerId(Model model) {
		model.addAttribute("message", "중복된 ID를 입력하셨습니다. 다시 진행해주세요.");
		model.addAttribute("resultPage", "/");
		return "message";
	}
	
}
