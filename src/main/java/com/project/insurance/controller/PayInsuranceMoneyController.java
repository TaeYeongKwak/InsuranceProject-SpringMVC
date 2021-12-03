package com.project.insurance.controller;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.exception.ClientSessionExpiredException;
import com.project.insurance.exception.ContractDataAccessException;
import com.project.insurance.exception.ContractNotFoundException;
import com.project.insurance.exception.DuplicatePayMoneyException;
import com.project.insurance.model.Client;
import com.project.insurance.model.Contract;
import com.project.insurance.service.ContractService;

@Controller
public class PayInsuranceMoneyController {
	//보험료 납부를 담당하는 컨트롤러
	
	@Autowired
	private ContractService contractService;
	
	
	@RequestMapping(value = "contract/info/pay", method = RequestMethod.GET)
	public String insuranceMoney(Model model, HttpServletRequest request, String productName) {
		try {
			HttpSession session = request.getSession();
			Client client = (Client) session.getAttribute("client");
			if(client == null) throw new ClientSessionExpiredException();
			
			Contract contract = contractService.searchByClientIdAndProductName(client.getId(), productName);
			if(contract == null) throw new ContractNotFoundException();
			
			model.addAttribute("contract", contract);
			model.addAttribute("insuranceMoney", contract.getInsuranceProduct().calculationRate(client));
			model.addAttribute("toMonth", LocalDate.now().getMonth().getValue());
			
		} catch (SQLException e) {
			throw new ContractDataAccessException();
		}
		return "payInsuranceMoney";
	}

	@RequestMapping(value = "contract/pay", method = RequestMethod.GET)
	public String payInsuranceMoney(Model model, HttpServletRequest request, String month, String productName) {
		try {
			HttpSession session = request.getSession();
			Client client = (Client) session.getAttribute("client");
			if(client == null) throw new ClientSessionExpiredException();
			
			Contract contract = contractService.searchByClientIdAndProductName(client.getId(), productName);
			if(contract == null) throw new ContractNotFoundException();
			
			boolean[] months = contract.getMonth();
			int selectMonth = Integer.parseInt(month);
			if(months[selectMonth-1]) throw new DuplicatePayMoneyException();
			
			months[selectMonth-1] = true;
			contract.setMonth(months);
			
			model.addAttribute("message", contractService.modifyContract(contract)? "보험료 납부가 완료되었습니다.":"보험료 납부에 실패하였습니다.");
			model.addAttribute("resultPage", "client/menu");
		} catch (SQLException e) {
			throw new ContractDataAccessException();
		}
		return "message";
	}
	
	
}
