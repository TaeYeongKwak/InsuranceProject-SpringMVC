package com.project.insurance.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.insurance.dao.ManagerDao;
import com.project.insurance.model.manager.Manager;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerdao;

	@Override
	public boolean register(Manager manager) throws SQLException{
		return managerdao.add(manager);
	}

	@Override
	public boolean delete(String id, String pw) throws SQLException{
		Manager manager = managerdao.search(id, pw);
		if (manager != null)
			return managerdao.delete(manager);
		else
			return false;
	}
	
	@Override
	public Manager login(String id, String pw) throws SQLException{
		return managerdao.search(id, pw);
	}

	@Override
	public Manager checkManagerID(String managerID) throws SQLException{
		return managerdao.search(managerID);
	}

}