package com.project.insurance.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.exception.AccidentNotFoundException;
import com.project.insurance.model.Accident;
import com.project.insurance.service.ContractService;

@Controller
public class AccidentInfoController {
	//사고 기록을 보여주는 화면의 컨트롤러
	private final ContractService contractService;
	
	public AccidentInfoController(ContractService contractService) {
		this.contractService = contractService;
	}
	
	@RequestMapping(value="accident/{accident_num}", method = RequestMethod.GET)
	public String accidentInfo(Model model, @PathVariable int accidentNum) {
		try {
			Accident accident = contractService.searchByAccidentNum(accidentNum);
			if(accident == null) throw new AccidentNotFoundException();
			model.addAttribute("accident", accident);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "accidentInfo";
	}
	
}
