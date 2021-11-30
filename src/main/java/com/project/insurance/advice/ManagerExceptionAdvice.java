package com.project.insurance.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.insurance.exception.ManagerNotFoundException;

@ControllerAdvice
public class ManagerExceptionAdvice {

	@ExceptionHandler(ManagerNotFoundException.class)
	public String managerNotFoundException(Model model) {

		model.addAttribute("message", "�ش� Manager�� �������� �ʽ��ϴ�.");
		model.addAttribute("resultPage", "/");
		return "message";
	}

}