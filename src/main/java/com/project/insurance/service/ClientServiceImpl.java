package com.project.insurance.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.insurance.dao.ClientDao;
import com.project.insurance.model.Client;


@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientdao;

	@Override
	public boolean register(Client client) throws SQLException  {
		return clientdao.add(client);
	}

	@Override
	public Client login(String id, String pw) throws SQLException {
		return clientdao.search(id, pw);
	}

	@Override
	public boolean delete(Client client) throws SQLException {
		return clientdao.delete(client);
	}

	@Override
	public Client checkClientID(String clientID) throws SQLException {
		System.out.println(clientID + " service");
		return clientdao.search(clientID);
	}
	

	@Override
	public boolean addMedicalHistory(Client client) throws SQLException {
		return clientdao.addMedicalHistory(client);
	}

	@Override
	public boolean modifyMedicalHistory(Client client) throws SQLException {
		return clientdao.modifyMedicalHistory(client);
	}

}
