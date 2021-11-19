package com.project.insurance.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.project.insurance.model.Contract;

@Repository
public class ContractDaoImpl implements ContractDao{

	@Override
	public boolean add(Contract contract) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Contract contract) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contract search(String clientID, String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contract> searchByClient(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contract> searchBySalesPerson(String salesPerson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Contract contract) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Contract> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
