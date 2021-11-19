package com.project.insurance.service;
import java.util.ArrayList;

import com.project.insurance.model.insurance.InsuranceProduct;

public interface InsuranceProductService {
	
	public ArrayList<InsuranceProduct> searchInsuranceProductByApproval(boolean approval); // 승인별 보험 리스트 조회
	
	public InsuranceProduct searchInsuranceProduct(String productName); // 보험 이름 조회
	
	public boolean addInsuranceProduct(InsuranceProduct insuranceProduct); // 보험 추가
	
	public boolean modifyInsuranceProduct(InsuranceProduct insuranceProduct); // 보험 변경
	
	public boolean deleteInsuranceProduct(InsuranceProduct insuranceProduct); // 보험 삭제
	
}