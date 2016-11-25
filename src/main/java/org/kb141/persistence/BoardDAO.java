package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.BoardVO;

public interface BoardDAO extends GenericDAO<BoardVO, Integer> {

    public List<BoardVO> getScroll(int page) throws Exception;
    
}
