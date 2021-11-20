package com.project.insurance.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.insurance.model.Contract;
import com.project.insurance.service.ContractService;
import com.project.insurance.type.InsuranceProductType;

@Controller(value="contract/list")
public class ContractListController {
	// 계약 리스트를 보여주는 화면의 컨트롤러
	
	private final ContractService contractService;
	
	public ContractListController(ContractService contractService) {
		this.contractService = contractService;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showList(Model model, @RequestParam("TYPE")String type) {
		try {
			ArrayList<Contract> list = contractService.searchListByInsuranceProductType(InsuranceProductType.valueOf(type));
			model.addAttribute("accidentList", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "contractList";
	}
	
	@RequestMapping(value="/uw", method = RequestMethod.GET)
	public String showUnderwriterList(Model model) {
		try {
			ArrayList<Contract> list = contractService.searchListByApproval(false);
			model.addAttribute("accidentList", list);
			model.addAttribute("mode", "uw");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "contractList";
	}
	
	@RequestMapping(value="/expire", method = RequestMethod.GET)
	public String showExpiredList(Model model, @RequestParam("TYPE")String type) {
		try {
			ArrayList<Contract> list = contractService.searchListByExpiredDate(InsuranceProductType.valueOf(type));
			model.addAttribute("accidentList", list);
			model.addAttribute("mode", "expire");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "contractList";
	}
	
	@RequestMapping(value="/sales", method = RequestMethod.GET)
	public String showSalesPersonList(Model model, String managerId) {
		try {
			ArrayList<Contract> list = contractService.searchListBySalesPerson(managerId);
			model.addAttribute("accidentList", list);
			model.addAttribute("mode", "sales");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "contractList";
	}
	
}
