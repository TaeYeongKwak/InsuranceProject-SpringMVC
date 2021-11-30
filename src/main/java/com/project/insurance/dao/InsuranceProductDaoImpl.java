package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.insurance.ActualExpense;
import com.project.insurance.model.insurance.Cancer;
import com.project.insurance.model.insurance.InsuranceProduct;
import com.project.insurance.model.insurance.Life;
import com.project.insurance.model.insurance.Pension;
import com.project.insurance.type.ActualExpenseType;
import com.project.insurance.type.CancerType;
import com.project.insurance.type.InsuranceProductType;

@Repository
public class InsuranceProductDaoImpl implements InsuranceProductDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public boolean add(InsuranceProduct insuranceProduct) throws SQLException { //2주차 (보험타입별 구분)
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("insurance_product_name", insuranceProduct.getProductName());
		map.put("basic_insurance_premium", Integer.toString(insuranceProduct.getBasicInsurancePremium()));
		map.put("insurance_money", Integer.toString(insuranceProduct.getInsuranceMoney()));
		map.put("insurance_product_type", insuranceProduct.getInsuranceProductType().toString());
		map.put("payment_cycle", Integer.toString(insuranceProduct.getPaymentCycle()));
		map.put("payment_period", Integer.toString(insuranceProduct.getPaymentCycle()));
		map.put("approval", Integer.toString(insuranceProduct.getApproval()));
		int result1 = sqlSession.insert("insuranceProduct_add", map);
		int result2 = 0;
		switch(insuranceProduct.getInsuranceProductType()) {
		case ACTUALEXPENSE:
			ActualExpense actualExpense = (ActualExpense) insuranceProduct;
			HashMap<String, String> actualExpenseMap = new HashMap<String, String>();
			actualExpenseMap.put("insurance_product_name", actualExpense.getProductName());
			actualExpenseMap.put("actual_expense_type", actualExpense.getActualExpenseType().toString());
			actualExpenseMap.put("limit_of_indemnity", Integer.toString(actualExpense.getLimitAge()));
			actualExpenseMap.put("limit_age", Integer.toString(actualExpense.getLimitAge()));
			actualExpenseMap.put("self_payment", Integer.toString(actualExpense.getLimitAge()));
			result2 = sqlSession.insert("actualexpense_add", actualExpenseMap);
			break;
		case CANCER:
			Cancer cancer = (Cancer)insuranceProduct;
			HashMap<String, String> cancerMap = new HashMap<String, String>();
			cancerMap.put("insurance_product_name", cancer.getProductName());
			cancerMap.put("guaranteed_type", cancer.getGuaranteedType().toString());
			cancerMap.put("limit_age", Integer.toString(cancer.getLimitAge()));
			result2 = sqlSession.insert("cancer_add", cancerMap);
			break;
		case LIFE:
			Life life = (Life)insuranceProduct;
			HashMap<String, String> lifeMap = new HashMap<String, String>();
			lifeMap.put("insurance_product_name", life.getProductName());
			lifeMap.put("required_payment_period", Integer.toString(life.getRequiredPaymentPeriod()));
			result2 = sqlSession.insert("life_add", lifeMap);
			break;
		case PENSION:
			Pension pension = (Pension)insuranceProduct;
			HashMap<String, String> pensionMap = new HashMap<String, String>();
			pensionMap.put("insurance_product_name", pension.getProductName());
			pensionMap.put("guaranteed_period", Integer.toString(pension.getGuaranteedPeriod()));
			result2 = sqlSession.insert("pension_add", pensionMap);
			break;
		default:
			break;
		}
		return (result1 == 1 & result2 == 1) ? true : false;
	}

	@Override
	public boolean update(InsuranceProduct insuranceProduct) {//2주차 (보험타입별 구분)
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("insurance_product_num", Integer.toString(insuranceProduct.getInsuranceProductNum()));
		map.put("insurance_product_name", insuranceProduct.getProductName());
		map.put("basic_insurance_premium", Integer.toString(insuranceProduct.getBasicInsurancePremium()));
		map.put("insurance_money", Integer.toString(insuranceProduct.getInsuranceMoney()));
		map.put("payment_cycle", Integer.toString(insuranceProduct.getPaymentCycle()));
		map.put("payment_period", Integer.toString(insuranceProduct.getPaymentCycle()));
		map.put("approval", Integer.toString(insuranceProduct.getApproval()));
		int result1 = sqlSession.update("insuranceProduct_update", map);
		int result2 = 0;
		switch(insuranceProduct.getInsuranceProductType()) {
		case ACTUALEXPENSE:
			ActualExpense actualExpense = (ActualExpense) insuranceProduct;
			HashMap<String, String> actualExpenseMap = new HashMap<String, String>();
			actualExpenseMap.put("insurance_product_name", actualExpense.getProductName());
			actualExpenseMap.put("actual_expense_type", actualExpense.getActualExpenseType().toString());
			actualExpenseMap.put("limit_of_indemnity", Integer.toString(actualExpense.getLimitAge()));
			actualExpenseMap.put("limit_age", Integer.toString(actualExpense.getLimitAge()));
			actualExpenseMap.put("self_payment", Integer.toString(actualExpense.getLimitAge()));
			result2 = sqlSession.update("actualexpense_update", actualExpenseMap);
			break;
		case CANCER:
			Cancer cancer = (Cancer)insuranceProduct;
			HashMap<String, String> cancerMap = new HashMap<String, String>();
			cancerMap.put("insurance_product_name", cancer.getProductName());
			cancerMap.put("guaranteed_type", cancer.getGuaranteedType().toString());
			cancerMap.put("limit_age", Integer.toString(cancer.getLimitAge()));
			result2 = sqlSession.update("cancer_update", cancerMap);
			break;
		case LIFE:
			Life life = (Life)insuranceProduct;
			HashMap<String, String> lifeMap = new HashMap<String, String>();
			lifeMap.put("insurance_product_name", life.getProductName());
			lifeMap.put("required_payment_period", Integer.toString(life.getRequiredPaymentPeriod()));
			result2 = sqlSession.update("life_update", lifeMap);
			break;
		case PENSION:
			Pension pension = (Pension)insuranceProduct;
			HashMap<String, String> pensionMap = new HashMap<String, String>();
			pensionMap.put("insurance_product_name", pension.getProductName());
			pensionMap.put("guaranteed_period", Integer.toString(pension.getGuaranteedPeriod()));
			result2 = sqlSession.update("pension_update", pensionMap);
			break;
		default:
			break;
		}
		return (result1 == 1 & result2 == 1) ? true : false;
	}

	@Override
	public boolean delete(InsuranceProduct insuranceProduct) throws SQLException {//delete문

		return sqlSession.delete("delete", insuranceProduct.getProductName()) == 1 ? true : false;
	}

	@Override
	public InsuranceProduct search(String productName) { //search
		HashMap<String, String> map = sqlSession.selectOne("insuranceProduct_selectOne", productName);
		InsuranceProductType type = InsuranceProductType.valueOf(map.get("insurance_product_type"));
		String query = "";
		switch(type) {
		case ACTUALEXPENSE: 
			query = "actualexpense_select"; 
			break;
		case CANCER:
			query = "cancer_select"; 
			break;
		case LIFE:
			query = "life_select"; 
			break;
		case PENSION:
			query = "pension_select"; 
			break;
		}
		HashMap<String, String> map2 = sqlSession.selectOne(query,productName);
		map.putAll(map2);
		return toInsuranceProduct(map);
	}

	private InsuranceProduct toInsuranceProduct(HashMap<String, String> map) { //search를 통해서 뽑아낸 하나의 내용을 보여준다. + 2주차 수정
		if (map != null) {
			try {
				InsuranceProductType type = InsuranceProductType.valueOf(map.get("insurance_product_type"));
				switch(type) {
				case ACTUALEXPENSE:
					ActualExpense actualExpense = new ActualExpense();//new 새로만들어서
					actualExpense.setInsuranceProductNum(Integer.parseInt(String.valueOf(map.get("insurance_product_num"))));
					actualExpense.setProductName(String.valueOf(map.get("insurance_product_name")));
					actualExpense.setInsuranceMoney(Integer.parseInt(String.valueOf(map.get("insurance_money"))));
					actualExpense.setBasicInsurancePremium(Integer.parseInt(String.valueOf(map.get("basic_insurance_premium"))));
					actualExpense.setInsuranceProductType(type);
					actualExpense.setPaymentCycle(Integer.parseInt(String.valueOf(map.get("payment_cycle"))));
					actualExpense.setPaymentPeriod(Integer.parseInt(String.valueOf(map.get("payment_period"))));
					actualExpense.setApproval(Integer.parseInt(String.valueOf(map.get("approval"))) == 1? true : false);
					
					actualExpense.setActualExpenseType(ActualExpenseType.valueOf(map.get("actual_expense_type")));
					actualExpense.setLimitOfIndemnity(Integer.parseInt(String.valueOf(map.get("limit_of_indemnity"))));
					actualExpense.setLimitAge(Integer.parseInt(String.valueOf(map.get("limit_age"))));
					actualExpense.setSelfPayment(Integer.parseInt(String.valueOf(map.get("self_payment"))));
					return actualExpense;
				case CANCER:
					Cancer cancer = new Cancer();
					cancer.setInsuranceProductNum(Integer.parseInt(String.valueOf(map.get("insurance_product_num"))));
					cancer.setProductName(String.valueOf(map.get("insurance_product_name")));
					cancer.setInsuranceMoney(Integer.parseInt(String.valueOf(map.get("insurance_money"))));
					cancer.setBasicInsurancePremium(Integer.parseInt(String.valueOf(map.get("basic_insurance_premium"))));
					cancer.setInsuranceProductType(type);
					cancer.setPaymentCycle(Integer.parseInt(String.valueOf(map.get("payment_cycle"))));
					cancer.setPaymentPeriod(Integer.parseInt(String.valueOf(map.get("payment_period"))));
					cancer.setApproval(Integer.parseInt(String.valueOf(map.get("approval"))) == 1? true : false);
					
					cancer.setGuaranteedType(CancerType.valueOf(map.get("guaranteed_type")));
					cancer.setLimitAge(Integer.parseInt(String.valueOf(map.get("limit_age"))));
					return cancer;
				case LIFE:
					Life life = new Life();
					life.setInsuranceProductNum(Integer.parseInt(String.valueOf(map.get("insurance_product_num"))));
					life.setProductName(String.valueOf(map.get("insurance_product_name")));
					life.setInsuranceMoney(Integer.parseInt(String.valueOf(map.get("insurance_money"))));
					life.setBasicInsurancePremium(Integer.parseInt(String.valueOf(map.get("basic_insurance_premium"))));
					life.setInsuranceProductType(type);
					life.setPaymentCycle(Integer.parseInt(String.valueOf(map.get("payment_cycle"))));
					life.setPaymentPeriod(Integer.parseInt(String.valueOf(map.get("payment_period"))));
					life.setApproval(Integer.parseInt(String.valueOf(map.get("approval"))) == 1? true : false);
					
					life.setRequiredPaymentPeriod(Integer.parseInt(String.valueOf(map.get("required_payment_period"))));
					return life;
				case PENSION:
					Pension pension = new Pension();
					pension.setInsuranceProductNum(Integer.parseInt(String.valueOf(map.get("insurance_product_num"))));
					pension.setProductName(String.valueOf(map.get("insurance_product_name")));
					pension.setInsuranceMoney(Integer.parseInt(String.valueOf(map.get("insurance_money"))));
					pension.setBasicInsurancePremium(Integer.parseInt(String.valueOf(map.get("basic_insurance_premium"))));
					pension.setInsuranceProductType(type);
					pension.setPaymentCycle(Integer.parseInt(String.valueOf(map.get("payment_cycle"))));
					pension.setPaymentPeriod(Integer.parseInt(String.valueOf(map.get("payment_period"))));
					pension.setApproval(Integer.parseInt(String.valueOf(map.get("approval"))) == 1? true : false);
					
					pension.setGuaranteedPeriod(Integer.parseInt(String.valueOf(map.get("guaranteed_period"))));
					return pension;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private InsuranceProduct toProduct(HashMap<String, String> map) {
		InsuranceProduct insuranceProduct = new InsuranceProduct();
		insuranceProduct.setInsuranceProductNum(Integer.parseInt(String.valueOf(map.get("insurance_product_num"))));
		insuranceProduct.setProductName(String.valueOf(map.get("insurance_product_name")));
		insuranceProduct.setInsuranceMoney(Integer.parseInt(String.valueOf(map.get("insurance_money"))));
		insuranceProduct.setInsuranceProductType(InsuranceProductType.valueOf(map.get("insurance_product_type")));
		insuranceProduct.setPaymentCycle(Integer.parseInt(String.valueOf(map.get("payment_cycle"))));
		insuranceProduct.setPaymentPeriod(Integer.parseInt(String.valueOf(map.get("payment_period"))));
		insuranceProduct.setApproval(Integer.parseInt(String.valueOf(map.get("approval"))) == 1? true : false);
		return insuranceProduct;
	}
	
	

	@Override
	public ArrayList<InsuranceProduct> searchListByApproval(boolean approval) { //생각해서 다시 만들기.
		List<HashMap<String, String>> insuranceMapList = sqlSession.selectList("insuranceProduct_selectByapproval", approval? 1:0);
		ArrayList<InsuranceProduct> insuranceArrayList = new ArrayList<InsuranceProduct>();
		for(HashMap<String, String> map : insuranceMapList) {
			insuranceArrayList.add(toProduct(map));
		}
		return insuranceArrayList;
	}

	@Override
	public InsuranceProduct checkInsuranceName(String productName) {
		return this.sqlSession.selectOne("insuranceProduct_selectOne",productName);
	}

}
