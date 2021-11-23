package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.insurance.model.insurance.InsuranceProduct;

public interface InsuranceProductDao {

	public boolean add(InsuranceProduct insuranceProduct) throws SQLException; // 보험 추가

	public boolean update(InsuranceProduct insuranceProduct); // 보험 변경
	
	public boolean delete(InsuranceProduct insuranceProduct) throws SQLException; // 보험 삭제
	
	public InsuranceProduct search(String productName); // 보험 조회
	
	public ArrayList<InsuranceProduct> searchListByApproval(boolean approval); // 승인별 보험 리스트 조회
	
	public InsuranceProduct checkInsuranceName(String productName); //21.11.20추가 - 보험명 중복 체크 용도
	
}