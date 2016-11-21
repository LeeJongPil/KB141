package org.kb141.persistence;

import java.util.List;

public interface GenericDAO<E,K> {

	public List<E> getList() throws Exception;
	
	
}
