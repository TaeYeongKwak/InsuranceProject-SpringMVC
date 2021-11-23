package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.insurance.InsuranceProduct;

@Repository
public class InsuranceProductDaoImpl implements InsuranceProductDao{

	private SqlSession sqlSession;

	@Override
	public boolean add(InsuranceProduct insuranceProduct) throws SQLException {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("insurance_product_name", insuranceProduct.getProductName());
		map.put("basic_insurance_premium", Integer.toString(insuranceProduct.getBasicInsurancePremium()));
		map.put("insurance_money", Integer.toString(insuranceProduct.getInsuranceMoney()));
		map.put("insurance_product_type", insuranceProduct.getInsuranceProductType().getInsuranceName());
		map.put("payment_cycle", Integer.toString(insuranceProduct.getPaymentCycle()));
		map.put("payment_period", Integer.toString(insuranceProduct.getPaymentCycle()));
		map.put("approval", Integer.toString(insuranceProduct.getApproval()));

		return sqlSession.insert("add", map) == 1 ? true : false;
	}

	@Override
	public boolean update(InsuranceProduct insuranceProduct) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("insurance_product_name", insuranceProduct.getProductName());
		map.put("basic_insurance_premium", Integer.toString(insuranceProduct.getBasicInsurancePremium()));
		map.put("insurance_money", Integer.toString(insuranceProduct.getInsuranceMoney()));
		map.put("insurance_product_type", insuranceProduct.getInsuranceProductType().getInsuranceName());
		map.put("payment_cycle", Integer.toString(insuranceProduct.getPaymentCycle()));
		map.put("payment_period", Integer.toString(insuranceProduct.getPaymentCycle()));
		map.put("approval", Integer.toString(insuranceProduct.getApproval()));

		return sqlSession.update("update",map) > 0 ? true : false;

	}

	@Override
	public boolean delete(InsuranceProduct insuranceProduct) throws SQLException {//delete문

		return sqlSession.delete("delete", insuranceProduct.getProductName()) == 1 ? true : false;
	}

	@Override
	public InsuranceProduct search(String productName) { //search
		HashMap<String, String> map = sqlSession.selectOne("insuranceProduct_selectOne", productName);
		return toInsuranceProduct(map);
	}

	private InsuranceProduct toInsuranceProduct(HashMap<String, String> map) { //search를 통해서 뽑아낸 하나의 내용을 보여준다.
		if (map != null) {
			InsuranceProduct insuranceProduct = new InsuranceProduct();
			try {
				insuranceProduct.setInsuranceProductNum(Integer.parseInt(String.valueOf(map.get("insurance_product_num"))));
				insuranceProduct.setProductName(String.valueOf(map.get("insurance_product_name")));
				insuranceProduct.setInsuranceMoney(Integer.parseInt(String.valueOf(map.get("insurance_money"))));
				insuranceProduct.setInsuranceProductType(insuranceProduct.getInsuranceProductType());
				insuranceProduct.setPaymentCycle(Integer.parseInt(String.valueOf(map.get("payment_cycle"))));
				insuranceProduct.setPaymentPeriod(Integer.parseInt(String.valueOf(map.get("payment_period"))));
				insuranceProduct.isApproval();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("1");
			}
		}
		return null;
	}

	@Override
	public ArrayList<InsuranceProduct> searchListByApproval(boolean approval) {
		/*
		 * List<HashMap<String, String>> insuranceList =
		 * sqlSession.selectList("searchListByApproval", approval);
		 * ArrayList<InsuranceProduct> insuranceArrayList = new
		 * ArrayList<InsuranceProduct>();
		 */
		return null;
	}

	@Override
	public InsuranceProduct checkInsuranceName(String productName) {
		
		return this.sqlSession.selectOne("insuranceProduct_selectOne",productName);
	}

}
