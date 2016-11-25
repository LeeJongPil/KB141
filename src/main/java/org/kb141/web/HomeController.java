package org.kb141.web;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.kb141.domain.BoardVO;
import org.kb141.persistence.TimeDAO;
import org.kb141.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */



@RestController
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	@Autowired
//	TimeDAO dao;
//	
//	@Inject
//	private SqlSession sqlSession;
//	
//	public void getTime() throws Exception{
//		
//		dao.getTime();
//		
//	}
	
	@Inject
	TimeDAO dao;

	@Inject
	BoardService service;
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@CrossOrigin
	@RequestMapping(value = "/123", method = RequestMethod.GET)
	public List<BoardVO> home(Model model) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		
		return service.showList(1);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/12" , produces={"text/plain; charset=UTF-8;"})
	public String testText(){
		
		
		return "hello";
	}
	

	
	
	
	
}
