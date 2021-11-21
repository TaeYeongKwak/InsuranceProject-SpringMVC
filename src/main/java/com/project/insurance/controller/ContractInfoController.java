package com.project.insurance.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.insurance.model.Contract;
import com.project.insurance.service.ContractService;

@Controller(value = "contract/info")
public class ContractInfoController {
	// 계약의 정보를 확인하는 화면의 컨트롤러
	private final ContractService contractService;
	
	public ContractInfoController(ContractService contractService) {
		this.contractService = contractService;
	}
	
	@RequestMapping(value = "/cm")
	public String showContractManagerContract(Model model, String clientId, String productName) {
		try {
			Contract contract = contractService.searchByClientIdAndProductName(clientId, productName);
			model.addAttribute("contract",contract);
			model.addAttribute("mode","cm");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "contractInfo";
	}
	
	@RequestMapping(value = "/uw")
	public String showUnderWriteContract(Model model, String clientId, String productName) {
		try {
			Contract contract = contractService.searchByClientIdAndProductName(clientId, productName);
			model.addAttribute("contract",contract);
			model.addAttribute("mode","uw");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "contractInfo";
	}
	
	@RequestMapping(value = "/expire")
	public String showExpiredContract(Model model, String clientId, String productName) {
		try {
			Contract contract = contractService.searchByClientIdAndProductName(clientId, productName);
			model.addAttribute("contract",contract);
			model.addAttribute("mode","expire");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "contractInfo";
	}
	
	@RequestMapping(value = "/sp")
	public String showSalesPersonContract(Model model, String clientId, String productName) {
		try {
			Contract contract = contractService.searchByClientIdAndProductName(clientId, productName);
			model.addAttribute("contract",contract);
			model.addAttribute("mode","sp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "contractInfo";
	}
}
