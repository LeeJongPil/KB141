package org.kb141.web;


import java.util.Locale;

import javax.inject.Inject;

import org.kb141.persistence.TimeDAO;
import org.kb141.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		model.addAttribute("list" , service.showList());
		
		
		
		
		
		return "home";
	}
	
}
