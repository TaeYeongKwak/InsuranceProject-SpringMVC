package com.project.insurance.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.project.insurance.model.Accident;

@Repository
public class AccidentDaoImpl implements AccidentDao{
	
	private final SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	public AccidentDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public boolean add(Accident accident) throws SQLException{
		sqlSession = sqlSessionFactory.openSession();
		try {
			int value = sqlSession.insert("accident_insert", accident);
			System.out.println(value);
			return true;
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public boolean delete(Accident accident) throws SQLException{
		sqlSession = sqlSessionFactory.openSession();
		try {
			int value = sqlSession.delete("accident_deleteOne", accident.getAccidentNum());
			System.out.println(value);
			return true;
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public Accident search(int accidentNum) throws SQLException{
		sqlSession = sqlSessionFactory.openSession();
		try {
			Accident accident = sqlSession.selectOne("accident_selectOne", accidentNum);
			return accident;
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public ArrayList<Accident> findAll() throws SQLException{
		sqlSession = sqlSessionFactory.openSession();
		try {
			List<Accident> accidentList = sqlSession.selectList("accident_selectAll");
			return new ArrayList<Accident>(accidentList);
		}finally {
			sqlSession.close();
		}
	}

}
