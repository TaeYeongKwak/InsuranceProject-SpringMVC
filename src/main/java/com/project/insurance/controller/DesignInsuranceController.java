package com.project.insurance.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "checkName", method = RequestMethod.GET)
	public String checkName() {

		return "designInsurance";
	}
}
