package com.project.insurance.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.exception.ClientSessionExpiredException;
import com.project.insurance.exception.ContractDataAccessException;
import com.project.insurance.exception.ContractNotFoundException;
import com.project.insurance.exception.ManagerSessionExpiredException;
import com.project.insurance.model.Client;
import com.project.insurance.model.Contract;
import com.project.insurance.model.manager.Manager;
import com.project.insurance.service.ContractService;
import com.project.insurance.type.InsuranceProductType;

@Controller
public class ContractListController {
	// 계약 리스트를 보여주는 화면의 컨트롤러
	
	@Autowired
	private ContractService contractService;
	
	@RequestMapping(value="contract/list/uw", method = RequestMethod.GET)
	public String showContractUnderWriter(Model model) {
		try {
			ArrayList<Contract> list = contractService.searchListByApproval(false);
			if(list.size() == 0) throw new ContractNotFoundException();
			
			model.addAttribute("contractList", list);
			model.addAttribute("mode", "uw");
		} catch (SQLException e) {
			throw new ContractDataAccessException();
		}
		return "contractList";
	}
	
	@RequestMapping(value="contract/list/cm/{type}", method = RequestMethod.GET)
	public String showContractContractManager(Model model, @PathVariable String type) {
		try {
			ArrayList<Contract> list = contractService.searchListByInsuranceProductType(InsuranceProductType.valueOf(type));
//			if(list.size() == 0) throw new ContractNotFoundException();
			
			model.addAttribute("contractList", list);
			model.addAttribute("mode", "cm");
		} catch (SQLException e) {
			throw new ContractDataAccessException();
		}
		return "contractList";
	}
	
	@RequestMapping(value="contract/list/expire/{type}", method = RequestMethod.GET)
	public String showContractExpire(Model model, @PathVariable String type) {
		try {
			ArrayList<Contract> list = contractService.searchListByExpiredDate(InsuranceProductType.valueOf(type));
//			if(list.size() == 0) throw new ContractNotFoundException();
			
			model.addAttribute("contractList", list);
			model.addAttribute("mode", "expire");
		} catch (SQLException e) {
			throw new ContractDataAccessException();
		}
		return "contractList";
	}
	
	@RequestMapping(value="contract/list/sp", method = RequestMethod.GET)
	public String showContractSalesPerson(Model model, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			Manager salesPerson = (Manager) session.getAttribute("manager");
			if(salesPerson == null) throw new ManagerSessionExpiredException();
			
			ArrayList<Contract> list = contractService.searchListBySalesPerson(salesPerson.getId());
			if(list.size() == 0) throw new ContractNotFoundException();
			
			model.addAttribute("contractList", list);
			model.addAttribute("mode", "sp");
		} catch (SQLException e) {
			throw new ContractDataAccessException();
		}
		return "contractList";
	}
	
	@RequestMapping(value="contract/list/client", method = RequestMethod.GET)
	public String showContractClient(Model model, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			Client client = (Client) session.getAttribute("client");
			if(client == null) throw new ClientSessionExpiredException();
			
			ArrayList<Contract> list = contractService.searchListByClientId(client.getId());
			if(list.size() == 0) throw new ContractNotFoundException();
			
			model.addAttribute("contractList", list);
			model.addAttribute("mode", "client");
		} catch (SQLException e) {
			throw new ContractDataAccessException();
		}
		return "contractList";
	}
	
}
