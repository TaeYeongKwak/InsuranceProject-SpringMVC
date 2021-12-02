package com.project.insurance.controller;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.exception.ClientDataAccessException;
import com.project.insurance.exception.ClientNotFoundException;
import com.project.insurance.exception.ContractDataAccessException;
import com.project.insurance.exception.DuplicateContractException;
import com.project.insurance.exception.InsuranceDataAccessException;
import com.project.insurance.exception.InsuranceNotFoundException;
import com.project.insurance.model.Client;
import com.project.insurance.model.Contract;
import com.project.insurance.model.MedicalHistory;
import com.project.insurance.model.insurance.InsuranceProduct;
import com.project.insurance.model.manager.Manager;
import com.project.insurance.service.ClientService;
import com.project.insurance.service.ContractService;
import com.project.insurance.service.InsuranceProductService;

@Controller
public class ContractController {
	// 계약을 맺는 화면의 컨트롤러
	@Autowired
	private ClientService clientService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private InsuranceProductService insuranceProductService;
	
	@RequestMapping(value = "contract/login", method = RequestMethod.POST)
	public String contractLogin(Model model, Client client, String productName) {
		try {
			Client cresult = clientService.login(client.getId(), client.getPassword());
			if(cresult == null) throw new ClientNotFoundException();
			
			if(contractService.searchByClientIdAndProductName(cresult.getId(), productName) != null)
				throw new DuplicateContractException();
			
			InsuranceProduct insuranceProduct = insuranceProductService.searchInsuranceProduct(productName);
			if(insuranceProduct == null) throw new InsuranceNotFoundException();
			model.addAttribute("client", cresult);
			model.addAttribute("insuranceProduct", insuranceProduct);
		} catch (SQLException e) {
			throw new ClientDataAccessException();
		}
		return "medicalHistory";
	}
	
	@RequestMapping(value = "contract/add", method = RequestMethod.POST)
	public String contractAdd(HttpServletRequest request, Model model, MedicalHistory medicalHistory, 
			String clientId, String productName) {
		try {
			HttpSession session = request.getSession();
			Manager salesPerson = (Manager) session.getAttribute("manager");
			Client cresult = clientService.checkClientID(clientId);
			if(cresult == null) throw new ClientNotFoundException();
			
			cresult.getMedicalHistory().setClientCancerCareer(medicalHistory.getClientCancerCareer());
			cresult.getMedicalHistory().setFamilyCancerCareer(medicalHistory.getClientCancerCareer());
			cresult.getMedicalHistory().setNumberOfHospitalizations(medicalHistory.getNumberOfHospitalizations());
			cresult.getMedicalHistory().setNumberOfHospitalVisits(medicalHistory.getNumberOfHospitalVisits());
			clientService.modifyMedicalHistory(cresult);
			
			boolean result = contractService.registerInsuranceProduct(this.makeContract(cresult, productName, salesPerson));
			model.addAttribute("message", result? "보험 가입 신청에 성공하였습니다." : "보험 가입 신청에 실패하였습니다.");
			model.addAttribute("resultPage", "manager/menu");
		} catch (SQLException e) {
			throw new ContractDataAccessException();
		}
		return "message";
	}
	
	private Contract makeContract(Client client, String productName, Manager manager) {
		try {
			Contract contract = new Contract();
			InsuranceProduct insuranceProduct = insuranceProductService.searchInsuranceProduct(productName);
			contract.setClient(client);
			contract.setInsuranceProduct(insuranceProduct);
			contract.setInsuranceContractDate(new Date());
			contract.setInsuranceExpiryDate(insuranceProduct.getPaymentPeriod());
			contract.setSalesPerson(manager);
			return contract;
		} catch (SQLException e) {
			throw new InsuranceDataAccessException();
		}
	}
	
}
