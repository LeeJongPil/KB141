package org.kb141.web;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.BoardVO;
import org.kb141.domain.FileVO;
import org.kb141.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Controller
public class BoardController {
	
	
		
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	@Inject
	private BoardService service;
	
	
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<BoardVO> home(Model model) {
		 
		return  service.showList();
	}
	
	
	@CrossOrigin
	@PostMapping("/register")
	public String writeBoard(BoardVO vo , FileVO fvo){
		
		service.register(vo , fvo);

		return "sucess..";
	}
	
	@CrossOrigin
	@PostMapping(value ="/view" , produces ="application/json; charset=utf-8" )
	public BoardVO viewBoard(String bno,Model model){
		BoardVO vo = new BoardVO();
		
		logger.info(bno);
		int no = Integer.parseInt(bno);
		
		

		return service.view(no);
	}
	
	@CrossOrigin
	@PostMapping("/modify")
	public String modifyBoard(BoardVO vo , FileVO fvo){
		
		service.modify(vo , fvo);

		return "sucess..";
	}
	
	@CrossOrigin
	@PostMapping("/remove")
	public String removeBoard(Integer num){
		
		service.remove(num);

		return "sucess..";
	}
	
	

}
