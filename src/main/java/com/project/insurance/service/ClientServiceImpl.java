package com.project.insurance.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.insurance.dao.ClientDao;
import com.project.insurance.dao.MedicalHistoryDao;
import com.project.insurance.model.Client;
import com.project.insurance.model.MedicalHistory;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	@Autowired
	private MedicalHistoryDao medicalHistoryDao;

	@Override
	public boolean register(Client client) throws SQLException {
		boolean result1 = clientDao.add(client);
		boolean result2 = medicalHistoryDao.add(client.getId(), client.getMedicalHistory());
		return (result1 && result2);
	}

	@Override
	public Client login(String id, String pw) throws SQLException {
		Client client = clientDao.search(id, pw);
		return this.insertMedicalHistory(client);
	}

	@Override
	public boolean delete(Client client) throws SQLException {
		return clientDao.delete(client);
	}

	@Override
	public Client checkClientID(String clientID) throws SQLException {
		return clientDao.search(clientID);
	}
	
	@Override
	public boolean modifyMedicalHistory(Client clientLogin) throws SQLException {
		return medicalHistoryDao.update(clientLogin.getId(), clientLogin.getMedicalHistory());
	}

	private Client insertMedicalHistory(Client client) throws SQLException {
		if (client != null) {
			MedicalHistory medicalHistory = medicalHistoryDao.search(client.getId());
			if (medicalHistory != null) {
				client.getMedicalHistory().setClientCancerCareer(medicalHistory.getClientCancerCareer());
				client.getMedicalHistory().setFamilyCancerCareer(medicalHistory.getClientCancerCareer());
				client.getMedicalHistory().setNumberOfHospitalizations(medicalHistory.getNumberOfHospitalizations());
				client.getMedicalHistory().setNumberOfHospitalVisits(medicalHistory.getNumberOfHospitalVisits());
			}
		}
		return client;
	}
}