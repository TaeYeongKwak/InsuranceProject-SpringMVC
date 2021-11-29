package com.project.insurance.dao;

import java.sql.SQLException;

import com.project.insurance.model.Client;

public interface ClientDao {
	
	public boolean add(Client client) throws SQLException; // ȸ�� �߰�
	
	public boolean delete(Client client) throws SQLException; // ȸ�� ����
	
	public Client search(String clientId) throws SQLException; // ȸ�� ID �ߺ� ��ȸ
	
	public Client search(String clientId, String password) throws SQLException; // ȸ�� �α���
	
	public boolean modifyClientInfo(Client client) throws SQLException; // ȸ�� ���� ����
	

	
	

}