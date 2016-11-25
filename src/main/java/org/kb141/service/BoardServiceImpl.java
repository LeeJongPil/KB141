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
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO dao;
	@Inject
	FileDAO fdao;

	@Transactional
	@Override
	public List<BoardVO> showList(Integer page) {
		List<BoardVO> list = null;
		try {
            list = dao.getScroll(page);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return list;
	}

	@Transactional
	@Override
	public void register(BoardVO vo, FileVO fvo) {

		try {
			dao.create(vo);
			fdao.create(fvo);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public BoardVO view(Integer bno) {

		BoardVO vo = null;


		try {
			vo = dao.read(bno);

		} catch (Throwable e) {
			e.printStackTrace();

		}

		return vo;

	}

	
	@Transactional
	@Override
	public void modify(BoardVO vo) {
		// �닔�젙�븯�뒗 遺�遺�
		try {
			dao.update(vo);
		} catch (Throwable e) {
			e.printStackTrace();

		}
	}

	@Transactional
	@Override
	public void remove(Integer bno) {
		try {
			dao.delete(bno);
			fdao.delete(bno);

			
		} catch (Throwable e) {
			e.printStackTrace();

		}
	}

	@Override
	public String getFileName(Integer bno) {

		FileVO vo = null;
		
		try{
			
			vo = fdao.read(bno);
			
			
			
		}catch(Throwable e){
			e.printStackTrace();
		}
		
		
		return vo.getBfile();
	}

	
	
	
	
	
	
}
