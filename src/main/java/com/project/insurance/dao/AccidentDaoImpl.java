package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.Accident;

@Repository
public class AccidentDaoImpl implements AccidentDao{
	
	private final SqlSession sqlSession;
	
	public AccidentDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean add(Accident accident) throws SQLException{
		int value = sqlSession.insert("accident_insert", accident);
		System.out.println(value);
		return true;
	}

	@Override
	public boolean delete(Accident accident) throws SQLException{
		int value = sqlSession.delete("accident_deleteOne", accident.getAccidentNum());
		System.out.println(value);
		return true;
	}

	@Override
	public Accident search(int accidentNum) throws SQLException{
		Accident accident = sqlSession.selectOne("accident_selectOne", accidentNum);
		return accident;
	}

	@Override
	public ArrayList<Accident> findAll() throws SQLException{
		List<Accident> accidentList = sqlSession.selectList("accident_selectAll");
		return new ArrayList<Accident>(accidentList);
	}

}
