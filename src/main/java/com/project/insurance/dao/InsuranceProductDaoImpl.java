package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.insurance.ActualExpense;
import com.project.insurance.model.insurance.Cancer;
import com.project.insurance.model.insurance.InsuranceProduct;
import com.project.insurance.model.insurance.Life;
import com.project.insurance.model.insurance.Pension;
import com.project.insurance.type.InsuranceProductType;

@Repository
public class InsuranceProductDaoImpl implements InsuranceProductDao{

	private SqlSession sqlSession;

	@Override
	public boolean add(InsuranceProduct insuranceProduct) throws SQLException { //2주차 (보험타입별 구분)
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("insurance_product_name", insuranceProduct.getProductName());
		map.put("basic_insurance_premium", Integer.toString(insuranceProduct.getBasicInsurancePremium()));
		map.put("insurance_money", Integer.toString(insuranceProduct.getInsuranceMoney()));
		map.put("insurance_product_type", insuranceProduct.getInsuranceProductType().getInsuranceName());
		map.put("payment_cycle", Integer.toString(insuranceProduct.getPaymentCycle()));
		map.put("payment_period", Integer.toString(insuranceProduct.getPaymentCycle()));
		map.put("approval", Integer.toString(insuranceProduct.getApproval()));
		
		switch(insuranceProduct.getInsuranceProductType()) {
		case ACTUALEXPENSE:
			ActualExpense actualExpense = (ActualExpense) insuranceProduct;
			map.put("actual_expense_num", Integer.toString(actualExpense.getInsuranceProductNum()));
			map.put("insurance_product_name", actualExpense.getProductName());
			map.put("actual_expense_type", actualExpense.getActualExpenseType().toString());
			map.put("limit_of_indemnity", Integer.toString(actualExpense.getLimitAge()));
			map.put("limit_age", Integer.toString(actualExpense.getLimitAge()));
			map.put("self_payment", Integer.toString(actualExpense.getLimitAge()));
			break;
		case CANCER:
			Cancer cancer = (Cancer)insuranceProduct;
			map.put("cancers_num", Integer.toString(cancer.getInsuranceProductNum()));
			map.put("insurance_product_name", cancer.getProductName());
			map.put("guaranteed_type", cancer.getInsuranceProductType().toString());
			map.put("limit_age", Integer.toString(cancer.getLimitAge()));
			break;
		case LIFE:
			Life life = (Life)insuranceProduct;
			map.put("lifes_num", Integer.toString(life.getInsuranceProductNum()));
			map.put("insurance_product_name", life.getProductName());
			map.put("required_payment_period", Integer.toString(life.getRequiredPaymentPeriod()));
			break;
		case PENSION:
			Pension pension = (Pension)insuranceProduct;
			map.put("pensions_num", Integer.toString(pension.getInsuranceProductNum()));
			map.put("insurance_product_name", pension.getProductName());
			map.put("guaranteed_period", Integer.toString(pension.getGuaranteedPeriod()));
			break;
		default:
			break;
		}
		return sqlSession.insert("add", map) == 1 ? true : false;
	}

	@Override
	public boolean update(InsuranceProduct insuranceProduct) {//2주차 (보험타입별 구분)
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("insurance_product_name", insuranceProduct.getProductName());
		map.put("basic_insurance_premium", Integer.toString(insuranceProduct.getBasicInsurancePremium()));
		map.put("insurance_money", Integer.toString(insuranceProduct.getInsuranceMoney()));
		map.put("payment_cycle", Integer.toString(insuranceProduct.getPaymentCycle()));
		map.put("payment_period", Integer.toString(insuranceProduct.getPaymentCycle()));
		map.put("approval", Integer.toString(insuranceProduct.getApproval()));
		
		switch(insuranceProduct.getInsuranceProductType()) {
		case ACTUALEXPENSE:
			ActualExpense actualExpense = (ActualExpense) insuranceProduct;
			map.put("insurance_product_name", actualExpense.getProductName());
			map.put("actual_expense_type", actualExpense.getActualExpenseType().toString());
			map.put("limit_of_indemnity", Integer.toString(actualExpense.getLimitAge()));
			map.put("limit_age", Integer.toString(actualExpense.getLimitAge()));
			map.put("self_payment", Integer.toString(actualExpense.getLimitAge()));
			break;
		case CANCER:
			Cancer cancer = (Cancer)insuranceProduct;
			map.put("insurance_product_name", cancer.getProductName());
			map.put("guaranteed_type", cancer.getInsuranceProductType().toString());
			map.put("limit_age", Integer.toString(cancer.getLimitAge()));
			break;
		case LIFE:
			Life life = (Life)insuranceProduct;
			map.put("insurance_product_name", life.getProductName());
			map.put("required_payment_period", Integer.toString(life.getRequiredPaymentPeriod()));
			break;
		case PENSION:
			Pension pension = (Pension)insuranceProduct;
			map.put("insurance_product_name", pension.getProductName());
			map.put("guaranteed_period", Integer.toString(pension.getGuaranteedPeriod()));
			break;
		default:
			break;
		}
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
					actualExpense.setInsuranceProductType(type);
					actualExpense.setPaymentCycle(Integer.parseInt(String.valueOf(map.get("payment_cycle"))));
					actualExpense.setPaymentPeriod(Integer.parseInt(String.valueOf(map.get("payment_period"))));
					actualExpense.isApproval();
					
					actualExpense.setActualExpenseType(actualExpense.getActualExpenseType());
					actualExpense.setLimitOfIndemnity(Integer.parseInt(String.valueOf(map.get("limit_of_indemnity"))));
					actualExpense.setLimitAge(Integer.parseInt(String.valueOf(map.get("limit_age"))));
					actualExpense.setSelfPayment(Integer.parseInt(String.valueOf(map.get("self_payment"))));
					break;
				case CANCER:
					Cancer cancer = new Cancer();
					cancer.setInsuranceProductNum(Integer.parseInt(String.valueOf(map.get("insurance_product_num"))));
					cancer.setProductName(String.valueOf(map.get("insurance_product_name")));
					cancer.setInsuranceMoney(Integer.parseInt(String.valueOf(map.get("insurance_money"))));
					cancer.setInsuranceProductType(type);
					cancer.setPaymentCycle(Integer.parseInt(String.valueOf(map.get("payment_cycle"))));
					cancer.setPaymentPeriod(Integer.parseInt(String.valueOf(map.get("payment_period"))));
					cancer.isApproval();
					
					cancer.setGuaranteedType(cancer.getCancerType());
					cancer.setLimitAge(Integer.parseInt(String.valueOf(map.get("limit_age"))));
					break;
				case LIFE:
					Life life = new Life();
					life.setInsuranceProductNum(Integer.parseInt(String.valueOf(map.get("insurance_product_num"))));
					life.setProductName(String.valueOf(map.get("insurance_product_name")));
					life.setInsuranceMoney(Integer.parseInt(String.valueOf(map.get("insurance_money"))));
					life.setInsuranceProductType(type);
					life.setPaymentCycle(Integer.parseInt(String.valueOf(map.get("payment_cycle"))));
					life.setPaymentPeriod(Integer.parseInt(String.valueOf(map.get("payment_period"))));
					life.isApproval();
					
					life.setRequiredPaymentPeriod(Integer.parseInt(String.valueOf(map.get("required_payment_period"))));
					break;
				case PENSION:
					Pension pension = new Pension();
					pension.setInsuranceProductNum(Integer.parseInt(String.valueOf(map.get("insurance_product_num"))));
					pension.setProductName(String.valueOf(map.get("insurance_product_name")));
					pension.setInsuranceMoney(Integer.parseInt(String.valueOf(map.get("insurance_money"))));
					pension.setInsuranceProductType(type);
					pension.setPaymentCycle(Integer.parseInt(String.valueOf(map.get("payment_cycle"))));
					pension.setPaymentPeriod(Integer.parseInt(String.valueOf(map.get("payment_period"))));
					pension.isApproval();
					
					pension.setGuaranteedPeriod(Integer.parseInt(String.valueOf(map.get("guaranteed_period"))));
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("1");
			}
		}
		return null;
	}

	@Override
	public ArrayList<InsuranceProduct> searchListByApproval(boolean approval) { //생각해서 다시 만들기.
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
