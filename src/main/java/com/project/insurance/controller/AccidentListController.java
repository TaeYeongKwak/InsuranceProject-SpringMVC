package com.project.insurance.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.insurance.service.ContractService;
import com.project.insurance.type.InsuranceProductType;

@Controller
public class AccidentListController {
	//사고 리스트를 보여주는 화면의 컨트롤러
	private final ContractService contractService;
	
	public AccidentListController(ContractService contractService) {
		this.contractService = contractService;
	}
	
	@RequestMapping(value="accident/list", method = RequestMethod.GET)
	public String showList(Model model, @RequestParam("TYPE")String type) {
		try {
			model.addAttribute("accidentList",
					contractService.searchAccidentListByProductType(InsuranceProductType.valueOf(type)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "accidentList";
	}
	
}
