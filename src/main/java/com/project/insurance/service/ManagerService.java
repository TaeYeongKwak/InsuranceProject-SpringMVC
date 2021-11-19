package com.project.insurance.service;

import com.project.insurance.model.manager.Manager;

public interface ManagerService {
	
	public boolean register(Manager manager); // 관리자 가입
	
	public Manager login(String id, String pw); // 관리자 로그인
	
	public boolean delete(String id, String pw); // 관리자 삭제
	
	public Manager checkManagerID(String managerID); // 관리자 ID 중복 조회
	
}