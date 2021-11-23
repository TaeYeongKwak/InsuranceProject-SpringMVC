package com.project.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.project.insurance.dao.ClientDao;

@Controller
public class InsuranceInfoController {
	// 보험상품의 정보를 확인하는 화면의 컨트롤러
	
	@Autowired
	private ClientDao clientDao;
	
}
