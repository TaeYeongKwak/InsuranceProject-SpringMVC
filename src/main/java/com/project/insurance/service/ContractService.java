package com.project.insurance.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.insurance.model.Accident;
import com.project.insurance.model.Contract;
import com.project.insurance.type.InsuranceProductType;

public interface ContractService {
	
	public Contract searchByClientIdAndProductName(String clientId, String productName) throws SQLException;
	
	public Accident searchByAccidentNum(int accidentNum) throws SQLException; 
	
	public ArrayList<Contract> searchListByApproval(boolean approval) throws SQLException; // 승인별 계약 리스트 조회
	
	public ArrayList<Accident> searchAccidentListByProductType(InsuranceProductType insuranceProductType) throws SQLException; // 보험타입별 사고 리스트 조회
	
	public ArrayList<Contract> searchListByInsuranceProductType(InsuranceProductType insuranceProductType) throws SQLException; // 보험타입별 계약 리스트 조회
	
	public ArrayList<Contract> searchListByExpiredDate(InsuranceProductType insuranceProductType) throws SQLException; // 만기 계약 리스트 조회
	
	public boolean deleteContract(Contract contract) throws SQLException; // 계약 삭제
	
	public boolean registerInsuranceProduct(Contract contract) throws SQLException; // 보험 계약
	
	public ArrayList<Contract> searchListBySalesPerson(String salesPerson) throws SQLException; // 영업사원별 계약 리스트 조회
	
	public boolean modifyContract(Contract contract) throws SQLException; // 계약 변경
	
	public ArrayList<Accident> applyAccidentList() throws SQLException; // 사고 접수 리스트 조회
	
	public boolean addApplyAccidentList(Accident accident) throws SQLException; // 사고 접수
	
	public boolean deleteAccidentList(Accident accident) throws SQLException; // 사고 삭제
}