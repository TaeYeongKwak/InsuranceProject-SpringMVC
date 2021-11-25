package com.project.insurance.dao;

import java.sql.SQLException;

import com.project.insurance.model.MedicalHistory;

public interface MedicalHistoryDao {
	
	public boolean add(String clientId, MedicalHistory medicalHistory) throws SQLException; // 의료기록 추가
	
	public boolean update(String clientId, MedicalHistory medicalHistory) throws SQLException; // 의료기록 변경
	
	public MedicalHistory search(String clientId) throws SQLException; // 회원 의료기록 검색
	
}