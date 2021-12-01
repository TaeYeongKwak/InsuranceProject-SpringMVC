package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.insurance.model.insurance.InsuranceProduct;

public interface InsuranceProductDao {

	public boolean add(InsuranceProduct insuranceProduct) throws SQLException; // 보험 추가

	public boolean update(InsuranceProduct insuranceProduct) throws SQLException; // 보험 변경
	
	public boolean delete(InsuranceProduct insuranceProduct) throws SQLException; // 보험 삭제
	
	public InsuranceProduct search(String productName) throws SQLException; // 보험 조회
	
	public ArrayList<InsuranceProduct> searchListByApproval(boolean approval) throws SQLException; // 승인별 보험 리스트 조회
	
}