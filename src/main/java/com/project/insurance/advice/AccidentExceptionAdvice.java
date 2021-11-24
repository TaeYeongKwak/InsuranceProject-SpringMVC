package com.project.insurance.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.insurance.exception.AccidentNotFoundException;

@ControllerAdvice
public class AccidentExceptionAdvice {
	
	@ExceptionHandler(AccidentNotFoundException.class)
	public String accidentNotFound(Model model) {
		model.addAttribute("message", "해당 사고가 존재하지 않습니다.");
		model.addAttribute("resultPage", "home");
		return "message";
	}

}
