package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.project.insurance.model.Client;
import com.project.insurance.type.ClientJobType;

@Repository
public class ClientDaoImpl implements ClientDao{
	
	
private final SqlSession sqlSession;
	
	public ClientDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean add(Client client)  throws SQLException {    // 고객 회원가입
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name",client.getName());
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
		return sqlSession.insert("Client_add", map) == 1 ? true : false;
	}

	@Override
	public boolean delete(Client client) throws SQLException{     //고객 삭제
		Map<String, String> map = new HashMap<String, String>();
		map.put("clientID", client.getId());
		
		return sqlSession.delete("Client_delete", map) > 0 ? true : false;   
		}

	@Override
	public Client search(String clientId) throws SQLException{    //고객 ID 중복 검사 
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("clientID", clientId);

		HashMap<String, String> ClientMap = sqlSession.selectOne("Client_search", map);
		return this.toClient(ClientMap);
	}
	
	@Override
	public Client search(String clientId, String password) throws SQLException{   // 고객 로그인
		Map<String, String> map = new HashMap<String, String>();
		map.put("clientID", clientId);
		map.put("clientPassWord", password);
		
		HashMap<String, String> ClientMap = sqlSession.selectOne("Client_login", map);
		return this.toClient(ClientMap);
	   }
	

	@Override
	public boolean modifyClientInfo(Client client) throws SQLException{  // 회원 정보 수정
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name",client.getName());
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
		return sqlSession.update("Client_update_info", client) > 0? true : false;
	}
	
	private Client toClient(Map<String, String> clientMap) {    //toClient 추가
		Client client = new Client();
		if (clientMap != null) {
			client.setId(String.valueOf(clientMap.get("client_id")));
			client.setName(String.valueOf(clientMap.get("name")));
			client.setAge(Integer.valueOf(clientMap.get("age")));
			client.setEmail(String.valueOf(clientMap.get("client_password")));
			client.setGender(Boolean.valueOf(clientMap.get("gender")));
			client.setPhoneNumber(String.valueOf(clientMap.get("phone_number")));
			client.setBankAccountNumber(String.valueOf(clientMap.get("bank_account_number")));
			client.setResidentRegistrationNumber(String.valueOf(clientMap.get("resident_registrationNumber")));
			client.setAddress(String.valueOf(clientMap.get("address")));
			client.setJob(ClientJobType.valueOf(clientMap.get("job")));
			return client;
		} else {
			return null;
		}
	}
	

	
	

}
