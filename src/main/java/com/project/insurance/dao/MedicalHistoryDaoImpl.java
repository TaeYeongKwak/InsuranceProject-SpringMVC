package com.project.insurance.dao;

import org.springframework.stereotype.Repository;

import com.project.insurance.model.MedicalHistory;

@Repository
public class MedicalHistoryDaoImpl implements MedicalHistoryDao{

	@Override
	public boolean add(String clientId, MedicalHistory medicalHistory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String clientId, MedicalHistory medicalHistory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MedicalHistory search(String clientId) {
		// TODO Auto-generated method stub
		return null;
	}

}
