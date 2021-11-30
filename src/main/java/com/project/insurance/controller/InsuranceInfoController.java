package com.project.insurance.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.insurance.exception.InsuranceNotFoundException;
import com.project.insurance.model.insurance.InsuranceProduct;
import com.project.insurance.service.InsuranceProductService;

@Controller
public class InsuranceInfoController {
	// 보험상품의 정보를 확인하는 화면의 컨트롤러
	
	@Autowired
	private InsuranceProductService insuranceProductService;
	
	@RequestMapping(value = "product/info/acceptance", method = RequestMethod.GET)
	public String insuranceInfoAcceptance(Model model, String productName) {
		InsuranceProduct insuranceProduct = insuranceProductService.searchInsuranceProduct(productName);
//		if(insuranceProduct == null) throw new InsuranceNotFoundException();
		
		model.addAttribute("insuranceProduct", insuranceProduct);
		model.addAttribute("type", "acceptance");
		return "insuranceInfo";
	}
	
	@RequestMapping(value = "product/info/salesperson", method = RequestMethod.GET)
	public String insuranceInfoSalesPerson(Model model, String productName) {
		InsuranceProduct insuranceProduct = insuranceProductService.searchInsuranceProduct(productName);
//		if(insuranceProduct == null) throw new InsuranceNotFoundException();
		
		model.addAttribute("insuranceProduct", insuranceProduct);
		model.addAttribute("type", "salesperson");
		return "insuranceInfo";
	}
	
	@RequestMapping(value = "product/info/manage", method = RequestMethod.GET)
	public String insuranceInfoManage(Model model, String productName) {
		InsuranceProduct insuranceProduct = insuranceProductService.searchInsuranceProduct(productName);
//		if(insuranceProduct == null) throw new InsuranceNotFoundException();
		
		model.addAttribute("insuranceProduct", insuranceProduct);
		model.addAttribute("type", "manage");
		return "insuranceInfo";
	}
	
	@RequestMapping(value = "product/info/delete", method = RequestMethod.GET)
	public String insuranceInfoDelete(Model model, String productName) {
		InsuranceProduct insuranceProduct = insuranceProductService.searchInsuranceProduct(productName);
//		if(insuranceProduct == null) throw new InsuranceNotFoundException();
		
		model.addAttribute("insuranceProduct", insuranceProduct);
		model.addAttribute("type", "delete");
		return "insuranceInfo";
	}
	
	@RequestMapping(value = "product/approval", method = RequestMethod.GET)
	public String insuranceAcceptance(Model model, String productName) {
		InsuranceProduct insuranceProduct = insuranceProductService.searchInsuranceProduct(productName);
		insuranceProduct.setApproval(true);
		model.addAttribute("message", insuranceProductService.modifyInsuranceProduct(insuranceProduct)? "승인에 성공하였습니다.":"승인에 실패하였습니다.");
		model.addAttribute("resultPage", "manager/menu");
		return "message";
	}
	
	@RequestMapping(value = "product/delete", method = RequestMethod.GET)
	public String insuranceDelete(Model model, String productName) {
		try {
			InsuranceProduct insuranceProduct = insuranceProductService.searchInsuranceProduct(productName);
			model.addAttribute("message", insuranceProductService.deleteInsuranceProduct(insuranceProduct)? "삭제에 성공하였습니다.":"삭제에 실패하였습니다.");
			model.addAttribute("resultPage", "manager/menu");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "message";
	}
	
}
