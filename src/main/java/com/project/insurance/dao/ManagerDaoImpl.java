package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.manager.Manager;
import com.project.insurance.type.ManagerType;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	private SqlSession sqlSession;

	// Manager 회원 가입
	@Override
	public boolean add(Manager manager) throws SQLException{
		return sqlSession.insert("Manager_add", manager) > 0 ? true : false;
	}

	// Manager 계정 삭제
	@Override
	public boolean delete(Manager manager) throws SQLException{
		return sqlSession.delete("Manager_delete", manager) > 0 ? true : false;
	}

	// Manager 로그인
	@Override
	public Manager search(String id, String password) throws SQLException{
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		HashMap<String, String> ManagerMap = sqlSession.selectOne("Manager_login", map);
		return this.toManager(ManagerMap);
	}

	// ManagerID 중복 검사
	@Override
	public Manager search(String managerID) throws SQLException{
		HashMap<String, String> ManagerMap = sqlSession.selectOne("Manager_search", managerID);
		return this.toManager(ManagerMap);
	}

	private Manager toManager(Map<String, String> map) {
		Manager manager = new Manager();
		if (map != null) {
			manager.setId(String.valueOf(map.get("manager_id")));
			manager.setPassword(String.valueOf(map.get("manager_password")));
			manager.setAge(Integer.parseInt(String.valueOf(map.get("age"))));
			manager.setName(String.valueOf(map.get("name")));
			manager.setJobPosition(ManagerType.valueOf(String.valueOf(map.get("manager_type"))));
			manager.setPhoneNumber(String.valueOf(map.get("phone_number")));
			return manager;
		} else {
			return null;
		}
	}


}
