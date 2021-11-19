package com.project.insurance.dao;

import com.project.insurance.model.manager.Manager;

public interface ManagerDao {
	
	public boolean add(Manager manager); // 관리자 추가
	
	public boolean delete(Manager manager); // 관리자 삭제
	
	public Manager search(String managerId, String password); // 관리자 조회
	
	public Manager search(String managerID); // 관리자 ID 조회
	
}