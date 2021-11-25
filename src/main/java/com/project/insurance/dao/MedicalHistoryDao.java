package com.project.insurance.dao;

import java.sql.SQLException;

import com.project.insurance.model.MedicalHistory;

public interface MedicalHistoryDao {
	
	public boolean add(String clientId, MedicalHistory medicalHistory) throws SQLException; // �Ƿ��� �߰�
	
	public boolean update(String clientId, MedicalHistory medicalHistory) throws SQLException; // �Ƿ��� ����
	
	public MedicalHistory search(String clientId) throws SQLException; // ȸ�� �Ƿ��� �˻�
	
}