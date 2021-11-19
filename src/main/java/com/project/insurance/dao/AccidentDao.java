package com.project.insurance.dao;
import java.util.ArrayList;

import com.project.insurance.model.Accident;

public interface AccidentDao {
	
	public boolean add(Accident accident); // 사고 추가
	
	public boolean delete(Accident accident); // 사고 삭제
	
	public Accident search(int accidentNum); // 사고 조회
	
	public ArrayList<Accident> findAll(); // 사고 리스트 조회
}