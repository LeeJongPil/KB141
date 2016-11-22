package org.kb141.persistence;

import org.kb141.domain.BoardVO;
import org.springframework.stereotype.Repository;

@Repository 
public class BoardDAOImpl extends AbstractDAO<BoardVO, Integer> implements BoardDAO {
	
	public BoardDAOImpl(){
		this.mapperName = "BoardMapper";
	}

	
	
}
