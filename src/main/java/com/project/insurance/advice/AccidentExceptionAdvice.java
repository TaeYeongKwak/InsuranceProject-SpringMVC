package com.project.insurance.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.insurance.exception.AccidentNotFoundException;

@ControllerAdvice
public class AccidentExceptionAdvice {
	
	@ExceptionHandler(AccidentNotFoundException.class)
	public String accidentNotFound(Model model) {
		model.addAttribute("message", "�ش� ��� �������� �ʽ��ϴ�.");
		model.addAttribute("resultPage", "manager/menu");
		return "message";
	}

}