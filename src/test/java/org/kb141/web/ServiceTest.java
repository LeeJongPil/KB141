package org.kb141.web;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.BoardVO;
import org.kb141.domain.FileVO;
import org.kb141.persistence.BoardDAO;
import org.kb141.persistence.FileDAO;
import org.kb141.service.BoardService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ServiceTest {

	@Inject
	private BoardDAO dao;

	@Inject
	private FileDAO fdao;

	@Inject
	private BoardService service;

	@Test
	public void showList() {
		System.out.println(service.showList());
	}

	@Test
	public void test() throws Exception {
		BoardVO vo = new BoardVO();

		System.out.println(vo.getBno());

	}

	@Test
	public void register() throws Exception {

		BoardVO vo = new BoardVO();

		FileVO fvo = new FileVO();

		vo.setBtitle("�꽩�뀋�꽮�꽩�뀋�꽮");
		vo.setBcontent("�뀒�뒪�듃�엯�땲�떎1231254135135.");
		vo.setBwriter("�옉�꽦�옄�엯�땲�떎");
		vo.setBsong("sadfs");
		vo.setBsinger("dfsdf");

		fvo.setBfile("寃쎈줈二쇱냼");

		try {
			service.register(vo, fvo);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println(vo);
		System.out.println(fvo);
	}

	@Test
	public void view() throws Exception {

		System.out.println(service.view(1));

	}

	@Test
	public void regsiter() throws Exception {
		BoardVO vo = new BoardVO();
		FileVO fvo = new FileVO();

		service.register(vo, fvo);
	}

	@Test
	public void modify() {
		BoardVO vo = new BoardVO();
		FileVO fvo = new FileVO();

		service.modify(vo, fvo);
	}

	@Test
	public void remove() {

		service.remove(2);
	}

	
	@Test
	public void removeALL(){
		
		String fileName = service.getFileName(5);
		service.remove(5);
		File delJpgFile = new File("E:\\zzz\\mp3server\\" + fileName +".jpg");
		File delMp3File = new File("E:\\zzz\\mp3server\\" + fileName +".mp3");
		
		if(delMp3File.delete() && delJpgFile.delete()){
		
			System.out.println("s");
		}
		else{

			System.out.println("n");
		}
	}
	
	
	/*
	 * public void register(BoardVO vo , FileVO fvo); public void view(Integer
	 * num); public void modify(BoardVO vo, FileVO fvo); public void
	 * remove(Integer num);
	 */

	@Test
	public void createTest() throws Exception {

		BoardVO vo = new BoardVO();
		vo.setBno(123123);
		vo.setBtitle("�뀋�뀋�뀋�뀋");
		vo.setBcontent("asefskjd");
		vo.setBwriter("sdfks");
		vo.setBsong("sdf");
		vo.setBsinger("sdfsdf");
		vo.setBcnt(123123);
		System.out.println(vo);
		dao.create(vo);

	}

	@Test
	public void readTest() throws Exception {
		System.out.println(service.view(115));

	}

}
