package com.project.insurance.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.insurance.model.Contract;

public interface ContractDao {
	
	public boolean add(Contract contract) throws SQLException; // 계약 추가
	
	public boolean delete(Contract contract) throws SQLException; // 계약 삭제
	
	public Contract search(String clientID, String productName) throws SQLException; // 계약 조회
	
	public ArrayList<Contract> searchByClient(String clientID) throws SQLException; // 회원별 계약 리스트 조회
	
	public ArrayList<Contract> searchBySalesPerson(String salesPerson) throws SQLException; // 영업사원별 계약 리스트 조회
	
	public boolean update(Contract contract) throws SQLException; // 계약 변경
	
	public ArrayList<Contract> findAll() throws SQLException; // 계약 리스트 조회
	
}