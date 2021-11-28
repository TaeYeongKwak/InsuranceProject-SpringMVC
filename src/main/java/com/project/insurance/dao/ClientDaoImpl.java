package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.Client;
import com.project.insurance.type.ClientJobType;

@Repository
public class ClientDaoImpl implements ClientDao {

	private final SqlSession sqlSession;

	public ClientDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean add(Client client) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", client.getName());
		map.put("age", client.getAge());
		map.put("gender", client.isGender() == true ? 1 : 0);
		map.put("id", client.getId());
		map.put("password", client.getPassword());
		map.put("phoneNumber", client.getPhoneNumber());
		map.put("email", client.getEmail());
		map.put("residentRegistrationNumber", client.getResidentRegistrationNumber());
		map.put("address", client.getAddress());
		map.put("bankAccountNumber", client.getBankAccountNumber());
		map.put("job", client.getJob());
		return sqlSession.insert("Client_insert", map) == 1 ? true : false;
	}

	@Override
	public boolean delete(Client client) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", client.getName());
		map.put("age", client.getAge());
		map.put("gender", client.isGender());
		map.put("id", client.getId());
		map.put("password", client.getPassword());
		map.put("phoneNumber", client.getPhoneNumber());
		map.put("email", client.getEmail());
		map.put("residentRegistrationNumber", client.getResidentRegistrationNumber());
		map.put("address", client.getAddress());
		map.put("bankAccountNumber", client.getBankAccountNumber());
		map.put("job", client.getJob());
		return sqlSession.delete("Client_delete", client) > 0 ? true : false;
	}

	@Override
	public Client search(String clientId) throws SQLException {
		HashMap<String, String> map = sqlSession.selectOne("Client_search", clientId);
		return toClient(map);
	}

	@Override
	public Client search(String clientId, String password) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", clientId);
		map.put("password", password);
		HashMap<String, String> clientMap = sqlSession.selectOne("Client_login", map);
		return toClient(clientMap);
	}

	private Client toClient(HashMap<String, String> map) {
		if (map != null) {
			Client client = new Client();
			client.setId(String.valueOf(map.get("client_id")));
			client.setName(String.valueOf(map.get("name")));
			client.setPassword(String.valueOf(map.get("client_password")));
			client.setAge(Integer.parseInt(String.valueOf(map.get("age"))));
			client.setEmail(String.valueOf(map.get("email")));
			client.setGender(Integer.parseInt(String.valueOf(map.get("gender"))) == 1 ? true : false);
			client.setPhoneNumber(String.valueOf(map.get("phone_number")));
			client.setBankAccountNumber(String.valueOf(map.get("bank_account_number")));
			client.setResidentRegistrationNumber(String.valueOf(map.get("resident_registrationNumber")));
			client.setAddress(String.valueOf(map.get("address")));
			client.setJob(ClientJobType.valueOf(map.get("job")));
			return client;
		}
		return null;
	}

}