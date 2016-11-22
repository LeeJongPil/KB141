package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.BoardVO;
import org.kb141.domain.FileVO;
import org.kb141.persistence.BoardDAO;
import org.kb141.persistence.FileDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	BoardDAO dao;
	@Inject
	FileDAO fdao;
	
	
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

	@Transactional
	@Override
	public void register(BoardVO vo , FileVO fvo) {
	
		try{
			dao.create(vo);
			fdao.create(fvo);
			
		}catch(Throwable e){
			e.printStackTrace();
		}	
	}
	
	@Transactional
	@Override
	public void view(Integer in){
		try{
			dao.read(in);
		}catch(Throwable e){
			e.printStackTrace();
			
		}
		
		
		
		
	}
	@Transactional
	@Override
	public void modify(BoardVO vo) {
		
		try{
			dao.update(vo);
		}catch(Throwable e){
			e.printStackTrace();
			
		}
	}
	@Transactional
	@Override
	public void remove(Integer in) {
		try{
			dao.delete(in);
		}catch(Throwable e){
			e.printStackTrace();
			
		}
	}
	
	
	
	

}
