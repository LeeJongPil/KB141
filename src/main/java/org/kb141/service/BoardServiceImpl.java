package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.BoardVO;
import org.kb141.persistence.BoardDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	BoardDAO dao;
	
	
	@Transactional
	@Override
	public List<BoardVO> showList() {
		List<BoardVO> list = null;
		try{
			 list = dao.getList();
		}catch(Throwable e){
			e.printStackTrace();
		}
		
		return list;

	}
	
	
	
	
	

}
