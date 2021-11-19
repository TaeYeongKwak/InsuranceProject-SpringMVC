package com.project.insurance.dao;

import com.project.insurance.model.Client;

public interface ClientDao {
	
	public boolean add(Client client); // 회원 추가
	
	public boolean delete(Client client); // 회원 삭제
	
	public Client search(String clientId); // 회원 ID 조회
	
	public Client search(String clientId, String password); // 회원 조회
	
}