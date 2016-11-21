package org.kb141.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.BoardVO;
import org.kb141.persistence.BoardDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ServiceTest {
	
	@Inject
	BoardDAO dao;
	
	
	
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
	
	
}
	
