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
	EmailService emailservice;
	
	   @RequestMapping(value = "email", method = RequestMethod.GET)
	   public String email() {
	      return "email";
	   }

	
	@RequestMapping(value = "email/send", method = RequestMethod.GET)
	public String send(@ModelAttribute Email dto, Model model) {
		try {
			System.out.println("dd" + dto.toString());
			emailservice.sendMail(dto);
			model.addAttribute("message", "이메일 발송이 완료되었습니다.");
			return "login";
			
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "이메일 발송이 실패했습니다.");
		}
		return "email";
	}
}
