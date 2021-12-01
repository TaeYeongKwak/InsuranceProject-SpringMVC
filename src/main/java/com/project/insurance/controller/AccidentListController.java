package com.project.insurance.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.exception.AccidentDataAccessException;
import com.project.insurance.model.Accident;
import com.project.insurance.service.ContractService;
import com.project.insurance.type.InsuranceProductType;

@Controller
public class AccidentListController {
	//사고 리스트를 보여주는 화면의 컨트롤러
	private final ContractService contractService;
	
	public AccidentListController(ContractService contractService) {
		this.contractService = contractService;
	}
	
	@RequestMapping(value="accident/list/{type}", method = RequestMethod.GET)
	public String showList(Model model, @PathVariable String type) {
		try {
			ArrayList<Accident> list = contractService.searchAccidentListByProductType(InsuranceProductType.valueOf(type));
//			if(list.size() == 0) throw new AccidentNotFoundException();
			model.addAttribute("accidentList", list);
		} catch (SQLException e) {
			throw new AccidentDataAccessException();
		}
		return "accidentList";
	}
	
}
