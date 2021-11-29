package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.MedicalHistory;
import com.project.insurance.type.CancerType;

@Repository
public class MedicalHistoryDaoImpl implements MedicalHistoryDao{

	private final SqlSession sqlSession;
	
	public MedicalHistoryDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean add(String clientId, MedicalHistory medicalHistory)  throws SQLException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("clientId" , clientId);		
		map.put("clientCancerCareer", medicalHistory.getClientCancerCareer());
		map.put("familyCancerCareer", medicalHistory.getFamilyCancerCareer());
		map.put("numberOfHospitalizations", medicalHistory.getNumberOfHospitalizations());
		map.put("numberOfHospitalVisits", medicalHistory.getNumberOfHospitalVisits());
		
		return sqlSession.insert("medicalHistory_insert", map) == 1 ? true : false;
		
	}

	@Override
	public boolean update(String clientId, MedicalHistory medicalHistory)  throws SQLException{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("clientId" , clientId);		
		map.put("clientCancerCareer", medicalHistory.getClientCancerCareer());
		map.put("familyCancerCareer", medicalHistory.getFamilyCancerCareer());
		map.put("numberOfHospitalizations", medicalHistory.getNumberOfHospitalizations());
		map.put("numberOfHospitalVisits", medicalHistory.getNumberOfHospitalVisits());
		
		return sqlSession.update("medicalHistory_update", map) > 0 ? true : false;
	}

	@Override
	public MedicalHistory search(String clientId)   throws SQLException {
		HashMap<String, String> map = sqlSession.selectOne("medicalHistory_search", clientId);
		return toMedicalHistory(map);
	}
	
	private MedicalHistory toMedicalHistory(HashMap<String, String> map) {
		MedicalHistory medicalHistory = new MedicalHistory();
		if(map != null) {
			medicalHistory.setClientCancerCareer(CancerType.valueOf(map.get("client_cancer_career")));
			medicalHistory.setFamilyCancerCareer(CancerType.valueOf(map.get("family_cancer_career")));
			medicalHistory.setNumberOfHospitalizations(Integer.parseInt(String.valueOf(map.get("number_of_hospitalizations"))));
			medicalHistory.setNumberOfHospitalVisits(Integer.parseInt(String.valueOf(map.get("number_of_hospitalVisits"))));
			return medicalHistory;
		}
		return null;
	}

}
