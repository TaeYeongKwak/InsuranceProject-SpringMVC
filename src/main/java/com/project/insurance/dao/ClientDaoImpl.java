package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.project.insurance.model.Client;

@Repository
public class ClientDaoImpl implements ClientDao{
	
	
private final SqlSession sqlSession;
	
	public ClientDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean add(Client client)  throws SQLException {
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
	public boolean delete(Client client) throws SQLException{
		return sqlSession.delete("Client_delete", client) > 0 ? true : false;
		}

	@Override
	public Client search(String clientId) throws SQLException{
		return sqlSession.selectOne("client_search", clientId);
		}
	@Override
	public Client search(String clientId, String password) throws SQLException{
		Client clientsearch = new Client();
		clientsearch.setId(clientId);
		clientsearch.setPassword(password);
		return sqlSession.selectOne("Client_login", clientsearch);
	   }
	@Override
	public boolean addMedicalHistory(Client client) throws SQLException{    // 회원 의료기록 추가
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("clientCancerCareer",client.getMedicalHistory().getClientCancerCareer());
		map.put("familyCancerCareer",client.getMedicalHistory().getFamilyCancerCareer());
		map.put("numberOfHospitalizations",client.getMedicalHistory().getNumberOfHospitalizations());
		map.put("numberOfHospitalVisits",client.getMedicalHistory().getNumberOfHospitalVisits());
		return sqlSession.insert("Client_addMedicalHistory",map) == 1? true : false;
		
	   }

	@Override
	public boolean modifyMedicalHistory(Client client) throws SQLException{   // 회원 의료기록 변경
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("clientCancerCareer",client.getMedicalHistory().getClientCancerCareer());
		map.put("familyCancerCareer",client.getMedicalHistory().getFamilyCancerCareer());
		map.put("numberOfHospitalizations",client.getMedicalHistory().getNumberOfHospitalizations());
		map.put("numberOfHospitalVisits",client.getMedicalHistory().getNumberOfHospitalVisits());
		return sqlSession.update("Client_mocifyMedicalHistory",map) > 0? true : false;
	}
	
	

}
