package org.kb141.web;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.BoardVO;
import org.kb141.domain.FileVO;
import org.kb141.domain.ReplyVO;
import org.kb141.persistence.BoardDAO;
import org.kb141.persistence.FileDAO;
import org.kb141.persistence.ReplyDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DBTester {

	@Inject // �뜲�씠�꽣 �냼�뒪瑜� �궡�젮 �떖�씪怨� �븯�뒗 嫄곕떎.
	private DataSource ds;

	@Inject
	private BoardDAO dao;
	
	@Inject
	private ReplyDAO rdao;
	
	@Inject
	private FileDAO fdao;
	
	@Test
	public void testgetList() throws Exception{
		
		System.out.println(dao.getList());
		
	}
	@Test
	public void createTest() throws Exception {
		
		BoardVO vo = new BoardVO();

		vo.setBtitle("�뀋�뀋�뀋�뀋");
		vo.setBcontent("asefskjd");
		vo.setBwriter("sdfks");
		vo.setBsong("sdf");
		vo.setBsinger("sdfsdf");
		
		
		System.out.println(vo);
		dao.create(vo);
	}
	
	@Test
	public void readTest() throws Exception{
		
		System.out.println(dao.read(115));	
	}
	
	@Test
	public void updateTest() throws Exception{
		BoardVO vo = new BoardVO();

		vo.setBtitle("�뀋�뀋�뀋�뀋");
		vo.setBcontent("asefskjd");
		vo.setBwriter("sdfks");
		vo.setBsong("sdf");
		vo.setBsinger("sdfsdf");
		vo.setBno(41);
		
		System.out.println(vo);
		dao.update(vo);
	
	}
	@Test
	public void deleteTest() throws Exception{
		
		dao.delete(32);
	}
	
	@Test
	public void createReplyTest() throws Exception{
		ReplyVO vo = new ReplyVO();
		
		vo.setBno(23);
		vo.setRwrite("�궃由ы뵆");
		vo.setRcontent("�궃由ы뵆�궡�슜");
	
		rdao.create(vo);
		
	}
	
	@Test
	public void readReplyTest() throws Exception{
		
		
		System.out.println(rdao.read(48));
	}
	@Test
	public void updateReplyTest() throws Exception{
		ReplyVO vo = new ReplyVO();

		vo.setBno(1233);
		vo.setRcontent("�궡�슜�씠�떎");
		vo.setRwrite("�궡�슜諛붾�뚯��떎");
		vo.setRno(48);
		System.out.println(vo);
		rdao.update(vo);
		
	}
	
	
	@Test
	public void deleteReplyTest() throws Exception{
		
		rdao.delete(50);
	}
	
	@Test
	public void testReplygetList() throws Exception{
		
		System.out.println(rdao.getList());
		
	}
	
	@Test
	public void testfileCreate() throws Exception{
		
		FileVO vo = new FileVO();

		vo.setBno(123);
		vo.setBfile("�뙆�씪寃쎈줈");
		
		System.out.println(vo);
		fdao.create(vo);
		
		
	}
	
	@Test
	public void readfileTest() throws Exception{
		
		fdao.read(1);	
	}
	
	@Test
	public void updatefileTest() throws Exception{
		FileVO vo = new FileVO();
		
		vo.setBfile("諛붾�먮궡�슜");
		vo.setBno(1);
		
		fdao.update(vo);
	}
	
	@Test
	public void deletefileTest() throws Exception{
		
		fdao.delete(1);
	}
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testDBConnection() throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.13:1521:xe", "bit88", "bit88");

		System.out.println(con);
		con.close();
	}

	
	@Test
	public void testDS() throws Exception {

		Connection con = ds.getConnection();
		System.out.println(con);
		con.close();

	}
	
	
	
	
	
}
