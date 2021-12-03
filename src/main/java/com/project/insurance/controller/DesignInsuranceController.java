package com.project.insurance.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.insurance.exception.InsuranceDataAccessException;
import com.project.insurance.exception.InsuranceNotFoundException;
import com.project.insurance.model.insurance.ActualExpense;
import com.project.insurance.model.insurance.Cancer;
import com.project.insurance.model.insurance.InsuranceProduct;
import com.project.insurance.model.insurance.Life;
import com.project.insurance.model.insurance.Pension;
import com.project.insurance.service.InsuranceProductService;

@Controller
public class DesignInsuranceController {
	// 보험 상품을 설계하는 화면의 컨트롤러

	@Autowired
	private InsuranceProductService insuranceProductService;

	@RequestMapping(value = "product/design/{type}", method = RequestMethod.GET)
	public String designInsurance(Model model, @PathVariable String type) {
		model.addAttribute("type", type);
		return "designInsurance";
	}

	@RequestMapping(value = "product/modify/{product_name}", method = RequestMethod.GET)
	public String modifyInsurance(Model model, @PathVariable("product_name") String productName) {
		try {
			InsuranceProduct insuranceProduct = insuranceProductService.searchInsuranceProduct(productName);
			if(insuranceProduct == null) throw new InsuranceNotFoundException();
			
			model.addAttribute("insuranceProduct", insuranceProduct);
			model.addAttribute("type", insuranceProduct.getInsuranceProductType().toString());
		} catch (SQLException e) {
			throw new InsuranceDataAccessException();
		}
		return "designInsurance";
	}

	@RequestMapping(value = "product/develop/cancer", method = RequestMethod.POST)
	public String developInsurance(Model model, Cancer cancer) {
		try {
			boolean result = insuranceProductService.addInsuranceProduct(cancer);
			String message = result ? "보험생성이 완료되었습니다." : "보험생성에 실패하였습니다.";
			model.addAttribute("message", message);
			model.addAttribute("resultPage", "manager/menu");
		} catch (SQLException e) {
			throw new InsuranceDataAccessException();
		}
		return "message";
	}

	@RequestMapping(value = "product/develop/pension", method = RequestMethod.POST)
	public String developInsurance(Model model, Pension pension) {
		try {
			boolean result = insuranceProductService.addInsuranceProduct(pension);
			String message = result ? "보험생성이 완료되었습니다." : "보험생성에 실패하였습니다.";
			model.addAttribute("message", message);
			model.addAttribute("resultPage", "manager/menu");
		} catch (SQLException e) {
			throw new InsuranceDataAccessException();
		}
		return "message";
	}

	@RequestMapping(value = "product/develop/life", method = RequestMethod.POST)
	public String developInsurance(Model model, Life life) {
		try {
			boolean result = insuranceProductService.addInsuranceProduct(life);
			String message = result ? "보험생성이 완료되었습니다." : "보험생성에 실패하였습니다.";
			model.addAttribute("message", message);
			model.addAttribute("resultPage", "manager/menu");
		} catch (SQLException e) {
			throw new InsuranceDataAccessException();
		}
		return "message";
	}

	@RequestMapping(value = "product/develop/actualExpense", method = RequestMethod.POST)
	public String developInsurance(Model model, ActualExpense acutalExpense) {
		try {
			boolean result = insuranceProductService.addInsuranceProduct(acutalExpense);
			String message = result ? "보험생성이 완료되었습니다." : "보험생성에 실패하였습니다.";
			model.addAttribute("message", message);
			model.addAttribute("resultPage", "manager/menu");
		} catch (SQLException e) {
			throw new InsuranceDataAccessException();
		}
		return "message";
	}

	@ResponseBody
	@RequestMapping(value = "product/checkName", method = RequestMethod.GET)
	public String checkName(@RequestParam String productName) {
		try {
			InsuranceProduct insuranceProduct = insuranceProductService.searchInsuranceProduct(productName);
			if (insuranceProduct == null)
				return "1";
		} catch (SQLException e) {
			throw new InsuranceDataAccessException();
		}
		return "0";
	}

	@RequestMapping(value = "product/modify/cancer", method = RequestMethod.POST)
	public String modifyInsurance(Model model, Cancer cancer) {
		try {
			boolean result = insuranceProductService.modifyInsuranceProduct(cancer);
			String message = result ? "보험수정이 완료되었습니다." : "보험수정에 실패하였습니다.";
			model.addAttribute("message", message);
			model.addAttribute("resultPage", "manager/menu");
		} catch (SQLException e) {
			throw new InsuranceDataAccessException();
		}
		return "message";
	}

	@RequestMapping(value = "product/modify/pension", method = RequestMethod.POST)
	public String modifyInsurance(Model model, Pension pension) {
		try {
			boolean result = insuranceProductService.modifyInsuranceProduct(pension);
			String message = result ? "보험수정이 완료되었습니다." : "보험수정에 실패하였습니다.";
			model.addAttribute("message", message);
			model.addAttribute("resultPage", "manager/menu");
		} catch (SQLException e) {
			throw new InsuranceDataAccessException();
		}
		return "message";
	}

	@RequestMapping(value = "product/modify/life", method = RequestMethod.POST)
	public String modifyInsurance(Model model, Life life) {
		try {
			boolean result = insuranceProductService.modifyInsuranceProduct(life);
			String message = result ? "보험수정이 완료되었습니다." : "보험수정에 실패하였습니다.";
			model.addAttribute("message", message);
			model.addAttribute("resultPage", "manager/menu");
		} catch (SQLException e) {
			throw new InsuranceDataAccessException();
		}
		return "message";
	}

	@RequestMapping(value = "product/modify/actualExpense", method = RequestMethod.POST)
	public String modifyInsurance(Model model, ActualExpense acutalExpense) {
		try {
			boolean result = insuranceProductService.modifyInsuranceProduct(acutalExpense);
			String message = result ? "보험수정이 완료되었습니다." : "보험수정에 실패하였습니다.";
			model.addAttribute("message", message);
			model.addAttribute("resultPage", "manager/menu");
		} catch (SQLException e) {
			throw new InsuranceDataAccessException();
		}
		return "message";
	}

}
