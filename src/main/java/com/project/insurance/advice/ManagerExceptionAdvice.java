package com.project.insurance.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.insurance.exception.ManagerNotFoundException;

@ControllerAdvice
public class ManagerExceptionAdvice {

	@ExceptionHandler(ManagerNotFoundException.class)
	public String managerNotFoundException(Model model) {

		model.addAttribute("message", "해당 Manager가 존재하지 않습니다.");
		model.addAttribute("resultPage", "/");
		return "message";
	}

}
