package com.project.insurance.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.project.insurance.model.insurance.InsuranceProduct;

@Repository
public class InsuranceProductDaoImpl implements InsuranceProductDao{

	@Override
	public boolean add(InsuranceProduct insuranceProduct) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(InsuranceProduct insuranceProduct) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(InsuranceProduct insuranceProduct) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InsuranceProduct search(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InsuranceProduct> searchListByApproval(boolean approval) {
		// TODO Auto-generated method stub
		return null;
	}

}
