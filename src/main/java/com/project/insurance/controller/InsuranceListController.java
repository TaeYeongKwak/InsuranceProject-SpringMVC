package com.project.insurance.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.insurance.exception.InsuranceNotFoundException;
import com.project.insurance.model.insurance.InsuranceProduct;
import com.project.insurance.service.InsuranceProductService;

@Controller
public class InsuranceListController {
	// 보험 리스트를 보여주는 화면의 컨트롤러
	
	@Autowired
	private InsuranceProductService insuranceProductService;
	
	@RequestMapping("product/list/acceptance")
	public String insuranceList(Model model) {
		ArrayList<InsuranceProduct> list = insuranceProductService.showInsuranceProductIsNotApproval();
		if(list.size() == 0) throw new InsuranceNotFoundException();
		model.addAttribute("type", "acceptance");
		model.addAttribute("insuranceList", list);
		return "insuranceList";
	}
	
	@RequestMapping("product/list/manage")
	public String insuranceListManage(Model model) {
		ArrayList<InsuranceProduct> list = insuranceProductService.showInsuranceProductIsNotApproval();
		if(list.size() == 0) throw new InsuranceNotFoundException();
		model.addAttribute("type", "manage");
		model.addAttribute("insuranceList", list);
		
		return "insuranceList";
	}
	
	@RequestMapping("product/list/delete")
	public String insuranceListDelete(Model model) {
		ArrayList<InsuranceProduct> list = insuranceProductService.showInsuranceProductIsApproval();
		if(list.size() == 0) throw new InsuranceNotFoundException();
		model.addAttribute("type", "delete");
		model.addAttribute("insuranceList", list);
		
		return "insuranceList";
	}
	
	@RequestMapping("product/list/salesperson")
	public String insuranceListSalesPerson(Model model) {
		ArrayList<InsuranceProduct> list = insuranceProductService.showInsuranceProductIsApproval();
		if(list.size() == 0) throw new InsuranceNotFoundException();
		model.addAttribute("type", "salesperson");
		model.addAttribute("insuranceList", list);
		return "insuranceList";
	}
	
}
