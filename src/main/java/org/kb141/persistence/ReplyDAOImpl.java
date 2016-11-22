package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.ReplyVO;
import org.springframework.stereotype.Repository;
@Repository 
public class ReplyDAOImpl extends AbstractDAO<ReplyVO, Integer> implements ReplyDAO {

	public ReplyDAOImpl(){
		this.mapperName = "ReplyMapper";
	}
}
