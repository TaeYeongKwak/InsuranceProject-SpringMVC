package com.project.insurance.service;

import com.project.insurance.model.Client;

public interface ClientService {
	
	public boolean register(Client client); // 회원 가입
	
	public Client login(String id, String pw); // 회원 로그인
	
	public boolean delete(String id, String pw); // 회원 탈퇴
	
	public Client checkClientID(String clientID); // 회원 가입시 ID 중복 조회
	
	public boolean addMedicalHistory(Client clientLogin); // 회원 의료기록 추가
	
	public boolean modifyMedicalHistory(Client clientLogin); // 회원 의료기록 변경
}