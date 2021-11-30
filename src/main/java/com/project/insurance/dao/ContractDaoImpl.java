package com.project.insurance.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.Client;
import com.project.insurance.model.Contract;
import com.project.insurance.model.insurance.InsuranceProduct;
import com.project.insurance.model.manager.Manager;

@Repository
public class ContractDaoImpl implements ContractDao{
	
	private final SqlSession sqlSession;
	
	public ContractDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean add(Contract contract) throws SQLException{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("insuranceContractDate",contract.getInsuranceContractDate());
		map.put("insuranceExpiryDate", contract.getInsuranceExpiryDate());
		map.put("managerId", contract.getSalesPerson().getId());
		map.put("approval", contract.isApproval()? 1:0);
		map.put("months", 0);
		map.put("clientID", contract.getClient().getId());
		map.put("insuranceProductName", contract.getInsuranceProduct().getProductName());
		return sqlSession.insert("contract_insert", map) == 1? true : false;
	}

	@Override
	public boolean delete(Contract contract) throws SQLException{
		Map<String, String> map = new HashMap<String, String>();
		map.put("clientID", contract.getClient().getId());
		map.put("insuranceProductName", contract.getInsuranceProduct().getProductName());
		return sqlSession.delete("contract_deleteOne", map) > 0? true : false;
		
	}

	@Override
	public Contract search(String clientID, String productName) throws SQLException{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("clientID", clientID);
		map.put("insuranceProductName", productName);
		
		HashMap<String, String> contractMap = sqlSession.selectOne("contract_selectOne", map);
		return this.toContract(contractMap);
		
	}

	@Override
	public ArrayList<Contract> searchByClient(String clientID) throws SQLException{
		List<HashMap<String, String>> contractList = sqlSession.selectList("contract_selectClientId", clientID);
		ArrayList<Contract> contractArray = new ArrayList<Contract>();
		for(int i = 0; i < contractList.size(); i++)
			contractArray.add(this.toContract(contractList.get(i)));
		return contractArray;
	}

	@Override
	public ArrayList<Contract> searchBySalesPerson(String salesPerson) throws SQLException{
		List<HashMap<String, String>> contractList = sqlSession.selectList("contract_selectManagerId", salesPerson);
		ArrayList<Contract> contractArray = new ArrayList<Contract>();
		for(int i = 0; i < contractList.size(); i++)
			contractArray.add(this.toContract(contractList.get(i)));
		return contractArray;
	}

	@Override
	public boolean update(Contract contract) throws SQLException{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("insuranceContractDate", new Date(contract.getInsuranceContractDate().getTime()));
		map.put("insuranceExpiryDate", new Date(contract.getInsuranceExpiryDate().getTime()));
		map.put("approval", contract.isApproval()? 1:0);
		map.put("months", this.monthBinary(contract.getMonth()));
		map.put("clientID", contract.getClient().getId());
		map.put("insuranceProductName", contract.getInsuranceProduct().getProductName());
		
		return sqlSession.update("contract_update", map) > 0 ? true : false;
		
	}

	@Override
	public ArrayList<Contract> findAll() throws SQLException{
		List<HashMap<String, String>> contractList = sqlSession.selectList("contract_selectAll");
		ArrayList<Contract> contractArray = new ArrayList<Contract>();
		for(int i = 0; i < contractList.size(); i++)
			contractArray.add(this.toContract(contractList.get(i)));
		return contractArray;
	}
	
	private Contract toContract(HashMap<String, String> contractMap) {
		if(contractMap != null) {
			Contract contract = new Contract();
			Client client = new Client();
			client.setId(String.valueOf(contractMap.get("client_id")));
			contract.setClient(client);
			InsuranceProduct insuranceProduct = new InsuranceProduct();
			insuranceProduct.setProductName(String.valueOf(contractMap.get("insurance_product_name")));
			contract.setInsuranceProduct(insuranceProduct);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			try {
				contract.setInsuranceContractDate(dateFormat.parse(String.valueOf(contractMap.get("insurance_contract_date"))));
				contract.setInsuranceExpiryDate(dateFormat.parse(String.valueOf(contractMap.get("insurance_expiry_date"))));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Manager manager = new Manager();
			manager.setId(String.valueOf(contractMap.get("manager_id")));
			contract.setSalesPerson(manager);
			contract.setApproval(Integer.parseInt(String.valueOf(contractMap.get("approval"))) == 1? true : false);
			contract.setMonth(this.monthBitMasking(Integer.parseInt(String.valueOf(contractMap.get("months")))));
			return contract;
		}
		return null;
	}
	
	private boolean[] monthBitMasking(int months) {
		boolean[] bMonths = new boolean[12];
		String binary = String.format("%012d", 
		Long.parseLong(Integer.toBinaryString(months)));
		char[] cMonths = binary.toCharArray();
		for(int i = 11; i >= 0; i--) {
			if(cMonths[i] == '0') {
				bMonths[11-i] = false;
			}else {
				bMonths[11-i] = true;
			}
		}
		return bMonths;
	}
	
	private int monthBinary(boolean[] months) {
		StringBuffer sb = new StringBuffer();
		for(int i = 11; i >= 0; i--) {
			if(months[i]) {
				sb.append("1");
			}else {
				sb.append("0");
			}
		}
		return Integer.parseInt(sb.toString(), 2);
	}

}
