package com.project.insurance.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.insurance.dao.InsuranceProductDao;
import com.project.insurance.model.insurance.InsuranceProduct;

@Service
public class InsuranceProductServiceImpl implements InsuranceProductService {

	@Autowired
	private InsuranceProductDao insuranceProductDao;

//	@Override 
//	public ArrayList<InsuranceProduct> searchInsuranceProductByApproval(boolean approval) { 
//		return insuranceProductDao.searchListByApproval(approval);
//	}

	@Override // 추후
	public ArrayList<InsuranceProduct> showInsuranceProductIsApproval() {
		return insuranceProductDao.searchListByApproval(true);
	}

	@Override // 추후
	public ArrayList<InsuranceProduct> showInsuranceProductIsNotApproval() {
		return insuranceProductDao.searchListByApproval(false);
	}

	@Override
	public InsuranceProduct searchInsuranceProduct(String productName) {

		return insuranceProductDao.search(productName);
	}

	@Override
	public boolean addInsuranceProduct(InsuranceProduct insuranceProduct) throws SQLException {
		return insuranceProductDao.add(insuranceProduct);
	}

	@Override
	public boolean modifyInsuranceProduct(InsuranceProduct insuranceProduct) {
		return insuranceProductDao.update(insuranceProduct);
	}

	@Override
	public boolean deleteInsuranceProduct(InsuranceProduct insuranceProduct) throws SQLException {
		return insuranceProductDao.delete(insuranceProduct);
	}

	@Override
	public InsuranceProduct checkInsuranceName(String InsuranceProductName) {
		return null;
	}

}