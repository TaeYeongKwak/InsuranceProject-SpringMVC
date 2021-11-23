package com.project.insurance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.insurance.dao.ClientDao;
import com.project.insurance.dao.InsuranceProductDao;
import com.project.insurance.model.Client;
import com.project.insurance.model.insurance.InsuranceProduct;

@Controller
public class InsuranceListController {
	// 보험 리스트를 보여주는 화면의 컨트롤러
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private InsuranceProductDao insuranceProductDao;
	
	@RequestMapping("/insuranceList")
	public String insuranceList(Model model, HttpServletRequest request) {
		String url = "";
		HttpSession session = request.getSession();															// session을 가져와서
		Client client = (Client) session.getAttribute("id");											// 가져온 session에서 고객 가져오기
		if (client != null) {																				// 그래서 고객이 존재하면
			List<InsuranceProduct> insuranceProduct = this.insuranceProductDao.searchListByApproval(true);  //승인된 것만 가져옴
			model.addAttribute("insuranceList", insuranceProduct);				
			url = "developedInsuranceList";																	// developedInsuranceList.jsp화면을 띄워준다.
		} else {																							// 고객이 존재하지 않으면
			//메세지 출력 구현하기
			url = "login";																						// 메인 화면을 띄워준다.
		}
		return url;
	}
}
