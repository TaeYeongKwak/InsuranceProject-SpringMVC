package com.project.insurance.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.insurance.exception.ContractNotFoundException;

@ControllerAdvice
public class ContractExceptionAdvice {
	
	@ExceptionHandler(ContractNotFoundException.class)
	public String contractException(Model model) {
		model.addAttribute("message", "해당 계약이 존재하지 않습니다.");
		model.addAttribute("resultPage", "home");
		return "message";
	}
	
}
