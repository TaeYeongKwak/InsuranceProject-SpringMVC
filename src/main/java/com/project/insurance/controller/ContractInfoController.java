package com.project.insurance.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.exception.ContractNotFoundException;
import com.project.insurance.model.Contract;
import com.project.insurance.service.ContractService;

@Controller
public class ContractInfoController {
	// 계약의 정보를 확인하는 화면의 컨트롤러
	
	@Autowired
	private ContractService contractService;
	
	@RequestMapping(value = "contract/info/{mode}")
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
	
	@RequestMapping(value="contract/underwrite", method = RequestMethod.GET)
	public String underwrite(Model model, String clientId, String productName) {
		System.out.println(clientId + " " + productName);
		try {
			Contract contract = contractService.searchByClientIdAndProductName(clientId, productName);
			contract.setApproval(true);
			
			model.addAttribute("message", contractService.modifyContract(contract)? "승인이 완료되었습니다.":"승인에 실패하였습니다.");
			model.addAttribute("resultPage", "contract/list/uw");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "message";
	}
	
	@RequestMapping(value = "contract/expire", method = RequestMethod.GET)
	public String expireDelete(Model model, String clientId, String productName) {
		return "message";
	}
	
}
