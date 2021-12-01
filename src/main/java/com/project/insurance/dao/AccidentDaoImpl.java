package com.project.insurance.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.Accident;
import com.project.insurance.model.Client;
import com.project.insurance.model.insurance.InsuranceProduct;

@Repository
public class AccidentDaoImpl implements AccidentDao{
	
	private final SqlSession sqlSession;
	
	public AccidentDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean add(Accident accident) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("clientId", accident.getClient().getId());
		map.put("insuranceProductName", accident.getInsuranceProduct().getProductName());
		map.put("accidentDetail", accident.getAccidentDetail());
		map.put("receptionDate", accident.getReceptionDate());
		return sqlSession.insert("accident_insert", map) == 1? true : false;
	}

	@Override
	public boolean delete(Accident accident) throws SQLException{
		return sqlSession.delete("accident_deleteOne", accident.getAccidentNum()) == 1? true : false;
	}

	@Override
	public Accident search(int accidentNum) throws SQLException{
		Map<String, String> map = sqlSession.selectOne("accident_selectOne", accidentNum);
		return toAccident(map);
	}

	@Override
	public ArrayList<Accident> findAll() throws SQLException{
		List<Map<String, String>> accidentMapList = sqlSession.selectList("accident_selectAll");
		ArrayList<Accident> list = new ArrayList<Accident>();
		for(Map<String, String> map : accidentMapList)
			list.add(toAccident(map));
		return list;
	}
	
	private Accident toAccident(Map<String, String> map){
		if(map != null) {
			Accident accident = new Accident();
			try {
				accident.setAccidentNum(Integer.parseInt(String.valueOf(map.get("accident_num"))));
				Client client = new Client();
				client.setId(map.get("client_Id"));
				accident.setClient(client);
				InsuranceProduct insuranceProduct = new InsuranceProduct();
				insuranceProduct.setProductName(String.valueOf(map.get("insurance_product_name")));
				accident.setInsuranceProduct(insuranceProduct);
				accident.setAccidentDetail(String.valueOf(map.get("accident_detail")));
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
				accident.setReceptionDate(dateFormat.parse(String.valueOf(map.get("reception_date"))));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			return accident;
		}else
			return null;
	}

}
