package com.project.insurance.dao;

import java.sql.SQLException;

import com.project.insurance.model.Client;

public interface ClientDao {
	
	public boolean add(Client client) throws SQLException; // 회원 추가
	
	public boolean delete(Client client) throws SQLException; // 회원 삭제
	
	public Client search(String clientId) throws SQLException; // 회원 ID 조회
	
	public Client search(String clientId, String password) throws SQLException; // 회원 조회
}