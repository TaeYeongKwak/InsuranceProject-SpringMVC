package com.project.insurance.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project.insurance.model.Accident;
import com.project.insurance.model.Contract;
import com.project.insurance.type.InsuranceProductType;

@Service
public class ContractServiceImpl implements ContractService{

	@Override
	public ArrayList<Contract> searchListByApproval(boolean approval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Accident> searchAccidentListByProductType(InsuranceProductType insuranceProductType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contract> searchListByInsuranceProductType(InsuranceProductType insuranceProductType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contract> searchListByExpiredDate(InsuranceProductType insuranceProductType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteContract(Contract contract) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerInsuranceProduct(Contract contract) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Contract> searchListBySalesPerson(String salesPerson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyContract(Contract contract) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Accident> applyAccidentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addApplyAccidentList(Accident accident) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccidentList(Accident accident) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
