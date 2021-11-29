package com.project.insurance.service;

import java.sql.SQLException;

import com.project.insurance.model.Client;

public interface ClientService {
	
	public boolean register(Client client) throws SQLException; // 회원 가입
	
	public Client login(String id, String pw) throws SQLException; // 회원 로그인
	
	public boolean delete(Client client) throws SQLException; // 회원 탈퇴
	
	public Client checkClientID(String clientID) throws SQLException; // 회원 가입시 ID 중복 조회
		
	public boolean modifyClientInfo(Client client) throws SQLException; // 회원 정보 수정
	

}