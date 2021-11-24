package com.project.insurance.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.insurance.exception.ContractNotFoundException;
import com.project.insurance.model.Contract;
import com.project.insurance.service.ContractService;

@Controller(value = "contract/info")
public class ContractInfoController {
	// 계약의 정보를 확인하는 화면의 컨트롤러
	
	@Autowired
	private ContractService contractService;
	
	@RequestMapping(value = "/{mode}")
	public String showContract(Model model, String clientId, String productName, @PathVariable String mode) {
		try {
			Contract contract = contractService.searchByClientIdAndProductName(clientId, productName);
			if(contract == null) throw new ContractNotFoundException();
			
			model.addAttribute("contract",contract);
			model.addAttribute("mode", mode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "contractInfo";
	}
	
}
