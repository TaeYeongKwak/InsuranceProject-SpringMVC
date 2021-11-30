package com.project.insurance.service;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.insurance.model.Email;

@Service
public class EmailServiceImpl implements EmailService {

	@Inject
	private JavaMailSender mailSender; //root-context.xml쪽 설정한 bean 의존 주입

	@Override
	public void sendMail(Email dto) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			System.out.println(message);
			
			message.addRecipient(RecipientType.TO, new InternetAddress(dto.getReceiveMail()));
			message.addFrom(new InternetAddress[] { new InternetAddress(dto.getSenderMail())});
			
			message.setSubject(dto.getSubject(), "utf-8");
			message.setText(dto.getMessage(), "utf-8");
			
			mailSender.send(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}