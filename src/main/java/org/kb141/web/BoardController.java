package org.kb141.web;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.BoardVO;
import org.kb141.domain.FileVO;
import org.kb141.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<BoardVO> home(Model model) {
		
		return service.showList();
	}
	
	
	@PostMapping("/register")
	public String writeContent(BoardVO vo , FileVO fvo){
		
		service.register(vo , fvo);
		
		
		
		
		return "list";
	}
	
	
	
	
	
	
	
	
	

}
