package com.project.insurance.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.manager.Manager;

@Repository
public class ManagerDaoImpl implements ManagerDao{
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public boolean add(Manager manager) {
		sqlSession.insert("Manager_add", manager);
		return true;
	}

	@Override
	public boolean delete(Manager manager) {
		sqlSession.delete("Manager_delete", manager);
		return false;
	}

	@Override
	public Manager search(String managerId, String password) {
		Manager managersearch = new Manager();
		managersearch.setId(managerId);
		managersearch.setPassword(password);
		sqlSession.selectList("Manager_login", managersearch);
		return null;
	}

	@Override
	public Manager search(String managerId) {
		sqlSession.selectOne("Manager_search", managerId);
		return null;
	}

}
