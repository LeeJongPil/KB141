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

	
	
	
	
}
