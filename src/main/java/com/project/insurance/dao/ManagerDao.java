package com.project.insurance.dao;

import java.sql.SQLException;

import com.project.insurance.model.manager.Manager;

public interface ManagerDao {
	
	public boolean add(Manager manager) throws SQLException; // 관리자 추가
	
	public boolean delete(Manager manager) throws SQLException; // 관리자 삭제
	
	public Manager search(String managerId, String password) throws SQLException; // 관리자 조회
	
	public Manager search(String managerID) throws SQLException; // 관리자 ID 조회
	
}