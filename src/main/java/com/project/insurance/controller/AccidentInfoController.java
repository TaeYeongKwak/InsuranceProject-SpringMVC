package com.project.insurance.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.exception.AccidentDataAccessException;
import com.project.insurance.exception.AccidentNotFoundException;
import com.project.insurance.model.Accident;
import com.project.insurance.service.ContractService;

@Controller
public class AccidentInfoController {
	//사고 기록을 보여주는 화면의 컨트롤러
	@Autowired
	private ContractService contractService;
	
	@RequestMapping(value="accident/{accident_num}", method = RequestMethod.GET)
	public String accidentInfo(Model model, @PathVariable("accident_num") String accidentNum) {
		try {
			Accident accident = contractService.searchByAccidentNum(Integer.parseInt(accidentNum));
			if(accident == null) throw new AccidentNotFoundException();
			model.addAttribute("accident", accident);
		} catch (SQLException e) {
			throw new AccidentDataAccessException();
		}
		return "accidentInfo";
	}
	
	@RequestMapping(value="product/pay/{accident_num}", method = RequestMethod.GET)
	public String payInsurancePremium(Model model, @PathVariable("accident_num") String accidentNum) {
		try {
			Accident accident = contractService.searchByAccidentNum(Integer.parseInt(accidentNum));
			if(accident == null) throw new AccidentNotFoundException();
			
			model.addAttribute("message", contractService.deleteAccidentList(accident)? "보험료 지급이 완료되었습니다." : "보험료 지급에 실패하였습니다.");
			model.addAttribute("resultPage", "manager/menu");
		} catch (SQLException e) {
			throw new AccidentDataAccessException();
		}
		return "message";
	}
	
}
