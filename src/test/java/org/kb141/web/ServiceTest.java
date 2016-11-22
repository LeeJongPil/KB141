package org.kb141.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.BoardVO;
import org.kb141.persistence.BoardDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class ServiceTest {
	
	@Inject
	private BoardDAO dao;

	
	@Test
	public void showList() {
		List<BoardVO> list = null;
		try{
			 list = dao.getList();
		}catch(Throwable e){
			e.printStackTrace();
		}
		
		System.out.println(list.toString());
}
	@Test
	public void createTest() throws Exception {
		
		
		BoardVO vo = new BoardVO();
		vo.setBno(123123);
		vo.setBtitle("ㅇㅇㅇㅇ");
		vo.setBcontent("asefskjd");
		vo.setBwriter("sdfks");
		vo.setBsong("sdf");
		vo.setBsinger("sdfsdf");
		vo.setBcnt(123123);
		System.out.println(vo);
		dao.create(vo);

			
		
	}
	
	
	
	
}
	
