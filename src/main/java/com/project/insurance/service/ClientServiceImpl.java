package com.project.insurance.service;

import org.springframework.stereotype.Service;

import com.project.insurance.model.Client;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Override
	public boolean register(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client login(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id, String pw) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client checkClientID(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMedicalHistory(Client clientLogin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyMedicalHistory(Client clientLogin) {
		// TODO Auto-generated method stub
		return false;
	}

}
