package com.project.insurance.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.insurance.exception.AccidentDataAccessException;
import com.project.insurance.exception.AccidentNotFoundException;

@ControllerAdvice
public class AccidentExceptionAdvice {
	
	@ExceptionHandler(AccidentNotFoundException.class)
	public String accidentNotFound(Model model) {
		model.addAttribute("message", "해당 사고가 존재하지 않습니다.");
		model.addAttribute("resultPage", "manager/menu");
		return "message";
	}
	
	@ExceptionHandler(AccidentDataAccessException.class)
	public String accidentDataAccess(Model model) {
		model.addAttribute("message", "사고에 접근하는 도중 오류가 발생하였습니다.");
		model.addAttribute("resultPage", "manager/menu");
		return "message";
	}

}
