package com.project.insurance.dao;
import java.util.ArrayList;

import com.project.insurance.model.Contract;

public interface ContractDao {
	
	public boolean add(Contract contract); // 계약 추가
	
	public boolean delete(Contract contract); // 계약 삭제
	
	public Contract search(String clientID, String productName); // 계약 조회
	
	public ArrayList<Contract> searchByClient(String clientID); // 회원별 계약 리스트 조회
	
	public ArrayList<Contract> searchBySalesPerson(String salesPerson); // 영업사원별 계약 리스트 조회
	
	public boolean update(Contract contract); // 계약 변경
	
	public ArrayList<Contract> findAll(); // 계약 리스트 조회
	
}