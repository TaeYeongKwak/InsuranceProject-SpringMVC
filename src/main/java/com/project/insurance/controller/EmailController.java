package com.project.insurance.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.model.Email;
import com.project.insurance.service.EmailService;

@Controller
public class EmailController {

	@Inject
	private EmailService emailService;

	@RequestMapping(value = "manager/email", method = RequestMethod.GET)
	public String email() {
		return "email";
	}

	@RequestMapping(value = "manager/email/send", method = RequestMethod.POST)
	public String send(@ModelAttribute Email email, Model model) {
		try {
			emailService.sendMail(email);
			model.addAttribute("message", "이메일 발송이 완료되었습니다.");
			
		} catch (Exception e) {
			model.addAttribute("message", "이메일 발송이 실패했습니다.");
		}
		model.addAttribute("resultPage", "manager/menu");
		return "message";
	}
}
