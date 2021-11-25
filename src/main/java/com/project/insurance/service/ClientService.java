package com.project.insurance.service;

import java.sql.SQLException;

import com.project.insurance.model.Client;

public interface ClientService {
	
	public boolean register(Client client) throws SQLException; // ȸ�� ����
	
	public Client login(String id, String pw) throws SQLException; // ȸ�� �α���
	
	public boolean delete(Client client) throws SQLException; // ȸ�� Ż��
	
	public Client checkClientID(String clientID) throws SQLException; // ȸ�� ���Խ� ID �ߺ� ��ȸ
	
	public boolean addMedicalHistory(Client client) throws SQLException; // ȸ�� �Ƿ��� �߰�
	
	public boolean modifyMedicalHistory(Client client) throws SQLException; // ȸ�� �Ƿ��� ����
}