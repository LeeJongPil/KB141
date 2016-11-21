package org.kb141.web;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.persistence.BoardDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DBTester {

	@Inject // 데이터 소스를 내려 달라고 하는 거다.
	private DataSource ds;

	@Inject
	private BoardDAO dao;
	
	
	@Test
	public void testgetList() throws Exception{
		
		System.out.println(dao.getList());
		
	}
	
	
	@Test
	public void testDBConnection() throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bit88", "bit88");

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
