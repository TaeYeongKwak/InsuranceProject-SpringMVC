package com.project.insurance.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.insurance.model.Accident;

public interface AccidentDao {
	
	public boolean add(Accident accident) throws SQLException; // 사고 추가
	
	public boolean delete(Accident accident) throws SQLException; // 사고 삭제
	
	public Accident search(int accidentNum) throws SQLException; // 사고 조회
	
	public ArrayList<Accident> findAll() throws SQLException; // 사고 리스트 조회
}