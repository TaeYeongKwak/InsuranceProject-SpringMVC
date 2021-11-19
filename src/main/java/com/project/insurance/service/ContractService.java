package com.project.insurance.service;

import java.util.ArrayList;

import com.project.insurance.model.Accident;
import com.project.insurance.model.Contract;
import com.project.insurance.type.InsuranceProductType;

public interface ContractService {
	
	public ArrayList<Contract> searchListByApproval(boolean approval); // 승인별 계약 리스트 조회
	
	public ArrayList<Accident> searchAccidentListByProductType(InsuranceProductType insuranceProductType); // 보험타입별 사고 리스트 조회
	
	public ArrayList<Contract> searchListByInsuranceProductType(InsuranceProductType insuranceProductType); // 보험타입별 계약 리스트 조회
	
	public ArrayList<Contract> searchListByExpiredDate(InsuranceProductType insuranceProductType); // 만기 계약 리스트 조회
	
	public boolean deleteContract(Contract contract); // 계약 삭제
	
	public boolean registerInsuranceProduct(Contract contract); // 보험 계약
	
	public ArrayList<Contract> searchListBySalesPerson(String salesPerson); // 영업사원별 계약 리스트 조회
	
	public boolean modifyContract(Contract contract); // 계약 변경
	
	public ArrayList<Accident> applyAccidentList(); // 사고 접수 리스트 조회
	
	public boolean addApplyAccidentList(Accident accident); // 사고 접수
	
	public boolean deleteAccidentList(Accident accident); // 사고 삭제
}