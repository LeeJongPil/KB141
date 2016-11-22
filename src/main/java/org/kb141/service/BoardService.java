package org.kb141.service;

import java.util.List;

import org.kb141.domain.BoardVO;
import org.kb141.domain.FileVO;

public interface BoardService {
	
	public List<BoardVO> showList();
	public void register(BoardVO vo , FileVO fvo);
	public void view(Integer in);
	public void modify(BoardVO vo); 
	public void remove(Integer in);
	


}
