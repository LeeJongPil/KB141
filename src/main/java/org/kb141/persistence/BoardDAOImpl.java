package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.BoardVO;
import org.springframework.stereotype.Repository;

@Repository 
public class BoardDAOImpl extends AbstractDAO<BoardVO, Integer> implements BoardDAO {
	
	public BoardDAOImpl(){
		this.mapperName = "BoardMapper";
	}

	@Override
	public List<BoardVO> getScroll(int page) throws Exception {
		return sqlSession.selectList("org.kb141.mapper." + mapperName + ".getScroll", page);
	}

	
	
}
