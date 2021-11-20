package com.project.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.insurance.dao.ManagerDao;
import com.project.insurance.model.manager.Manager;

public class ManagerServiceImpl implements ManagerService{
	
	
	@Autowired
	private ManagerDao managerList;
	
	@Override
	public boolean register(Manager manager) {
		return managerList.add(manager);
	}

	@Override
	public Manager login(String id, String pw) {
		return managerList.search(id, pw);
	}

	@Override
	public boolean delete(String id, String pw) {
		Manager manager = managerList.search(id, pw);
		if(manager != null)
			return managerList.delete(manager);
		else 
			return false;
	}

	@Override
	public Manager checkManagerID(String managerID) {
		return managerList.search(managerID);
	}

}
