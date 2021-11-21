package com.project.insurance.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.manager.Manager;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public boolean add(Manager manager) {
		return sqlSession.insert("Manager_add", manager) > 0 ? true : false;
	}

	@Override
	public boolean delete(Manager manager) {
		return sqlSession.delete("Manager_delete", manager) > 0 ? true : false;
	}

	@Override
	public Manager search(String id, String password) {
		Manager managersearch = new Manager();
		managersearch.setId(id);
		managersearch.setPassword(password);
		return sqlSession.selectOne("Manager_login", managersearch);

	}

	@Override
	public Manager search(String id) {
		return sqlSession.selectOne("Manager_search", id);
	}

}
