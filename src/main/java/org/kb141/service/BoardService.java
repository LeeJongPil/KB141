package org.kb141.service;

import java.util.List;

import org.kb141.domain.BoardVO;
import org.kb141.domain.FileVO;

public interface BoardService {
	
	public void register(BoardVO vo , FileVO fvo);
	public BoardVO view(Integer bno);
	public void modify(BoardVO vo); 
	public void remove(Integer bno);
	public String getFileName(Integer bno);
	public List<BoardVO> showList(Integer page);

}
