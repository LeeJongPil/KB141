package org.kb141.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TimeDAOImpl implements TimeDAO {

	
	@Inject 
	private SqlSession sqlSession;
	
	
	
	@Override
	public String now() {
		return sqlSession.selectOne("org.kb141.dao.TimeMapper.getTime");
		
		

	}

}
