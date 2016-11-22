package org.kb141.persistence;

import java.util.List;

public interface GenericDAO<E,K> {

	public List<E> getList() throws Exception;
	
	public void create(E vo) throws Exception;
	
	public E read(K Integer)throws Exception;
	
	public void update(E vo) throws Exception;
	
	public void delete(K Integer) throws Exception;
	
	
	
	
	
}
