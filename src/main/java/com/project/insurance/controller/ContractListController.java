package com.project.insurance.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.insurance.exception.ContractNotFoundException;
import com.project.insurance.model.Contract;
import com.project.insurance.service.ContractService;
import com.project.insurance.type.InsuranceProductType;

@Controller(value="contract/list")
public class ContractListController {
	// 계약 리스트를 보여주는 화면의 컨트롤러
	
	@Autowired
	private ContractService contractService;
	
	@RequestMapping(value="/{mode}", method = RequestMethod.GET)
	public String showContract(Model model, @RequestParam("TYPE")String type, @PathVariable String mode) {
		try {
			ArrayList<Contract> list = contractService.searchListByInsuranceProductType(InsuranceProductType.valueOf(type));
			if(list.size() == 0) throw new ContractNotFoundException();
			
			model.addAttribute("contractList", list);
			model.addAttribute("mode", mode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "contractList";
	}
	
}
