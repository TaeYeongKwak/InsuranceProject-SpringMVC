package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import com.project.insurance.model.MedicalHistory;


@Repository
public class MedicalHistoryDaoImpl implements MedicalHistoryDao{
	
	
	private final SqlSession sqlSession;
	
	public MedicalHistoryDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean add(String clientId, MedicalHistory medicalHistory)  throws SQLException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("clientId" , medicalHistory.getClient().getId());		
		map.put("clientCancerCareer", medicalHistory.getClientCancerCareer());
		map.put("familyCancerCareer", medicalHistory.getFamilyCancerCareer());
		map.put("numberOfHospitalizations", medicalHistory.getNumberOfHospitalizations());
		map.put("numberOfHospitalVisits", medicalHistory.getNumberOfHospitalVisits());
		
		return sqlSession.insert("MedicalHistory_add", medicalHistory) == 1 ? true : false;
		
	}

	@Override
	public boolean update(String clientId, MedicalHistory medicalHistory)  throws SQLException{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("clientId" , medicalHistory.getClient().getId());		
		map.put("clientCancerCareer", medicalHistory.getClientCancerCareer());
		map.put("familyCancerCareer", medicalHistory.getFamilyCancerCareer());
		map.put("numberOfHospitalizations", medicalHistory.getNumberOfHospitalizations());
		map.put("numberOfHospitalVisits", medicalHistory.getNumberOfHospitalVisits());
	
		return sqlSession.update("MedicalHistory_Update", medicalHistory) > 0 ? true : false;
	}

	@Override
	public MedicalHistory search(String clientId)   throws SQLException {
		return sqlSession.selectOne("MedicalHistory_search", clientId);
	}

}
