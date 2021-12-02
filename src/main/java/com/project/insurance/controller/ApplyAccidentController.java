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

import com.project.insurance.exception.AccidentDataAccessException;
import com.project.insurance.model.Accident;
import com.project.insurance.model.Client;
import com.project.insurance.model.insurance.InsuranceProduct;
import com.project.insurance.service.ContractService;
import com.project.insurance.service.InsuranceProductService;

@Controller
public class ApplyAccidentController {
   // 사고 접수 화면의 컨트롤러
   @Autowired
   ContractService contractService;
   @Autowired
   InsuranceProductService insuranceProductService;
   
   @RequestMapping(value="accident/apply", method = RequestMethod.GET)
   public String applyAccident(Model model, String productName) {
      model.addAttribute("productName", productName);
      return "applyAccident";
   }
   
   @RequestMapping(value="accident/apply/add", method = {RequestMethod.GET, RequestMethod.POST})
   public String addAccident(HttpServletRequest request, Model model, Accident accident, String productName) throws SQLException {
      try {
         insuranceProductService.searchInsuranceProduct(productName);
         InsuranceProduct insuranceProduct = insuranceProductService.searchInsuranceProduct(productName); 
         HttpSession session = request.getSession();
         Client client = (Client) session.getAttribute("client");
         
         accident.setClient(client);
         accident.setInsuranceProduct(insuranceProduct);
         accident.setReceptionDate(new Date());
         
         boolean result = contractService.addApplyAccidentList(accident);
         String message = result? "사고접수가 완료되었습니다.": "사고접수에 실패하였습니다.";
         model.addAttribute("message", message);
         model.addAttribute("resultPage", "client/menu");
      }catch(SQLException e) {
    	  throw new AccidentDataAccessException();
      }
      return "message";
   }
}
