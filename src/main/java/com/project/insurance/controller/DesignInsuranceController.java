package com.project.insurance.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.service.InsuranceProductService;

@Controller
public class DesignInsuranceController {
	// 보험 상품을 설계하는 화면의 컨트롤러
	
	@RequestMapping(value = "product/List", method = RequestMethod.GET)
	public String insuranceList() {
		return "insuranceList";
	}
	
	@RequestMapping(value = "Design", method = RequestMethod.GET)
	public String designInsurance() {
		
		return "designInsurance";
	}
}
