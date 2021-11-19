package com.project.insurance.dao;

import com.project.insurance.model.MedicalHistory;

public interface MedicalHistoryDao {
	
	public boolean add(String clientId, MedicalHistory medicalHistory); // 의료기록 추가
	
	public boolean update(String clientId, MedicalHistory medicalHistory); // 의료기록 변경
	
	public MedicalHistory search(String clientId); // 회원 의료기록 검색
	
}