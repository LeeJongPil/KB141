package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public abstract class AbstractDAO<E,K> implements GenericDAO<E, K> {

	protected String mapperName;
	
	@Inject
	protected SqlSession sqlSession;
	
	@Override
	public List<E> getList() throws Exception {

		return sqlSession.selectList("org.kb141.mapper." + mapperName + ".getList");
	}

	@Override
	public void create(E vo) throws Exception { 
		sqlSession.insert("org.kb141.mapper." + mapperName + ".create",vo);
		
	}

	@Override
	public E read(K Integer) throws Exception {
		
		return sqlSession.selectOne("org.kb141.mapper." + mapperName + ".read", Integer);
	}

	@Override
	public void update(E vo) throws Exception {
		sqlSession.update("org.kb141.mapper." + mapperName + ".update", vo);
		
	}

	@Override
	public void delete(K Integer) throws Exception {
		sqlSession.delete("org.kb141.mapper." + mapperName + ".delete", Integer);
		
	}

	
	
	
	
}
