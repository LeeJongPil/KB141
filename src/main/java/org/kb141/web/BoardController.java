package org.kb141.web;

import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.kb141.domain.BoardVO;
import org.kb141.domain.FileVO;
import org.kb141.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@PostMapping("/uploadFile")
	@ResponseBody // 이것을 하면 순수한 문자열이라고 알려준다.
	public String uploadFile(MultipartFile file)throws Exception {

		UUID uid = UUID.randomUUID(); // 유니크한 값을 주기위해서 UUID 라는걸 쓴다.
		String fileName = file.getOriginalFilename();
		String uploadName = uid + "_senyo_" + fileName;	

		FileOutputStream fos = new FileOutputStream("E:\\zzz\\" + uploadName);
		
		// db 에 저장할 때, 11.mp3 
		// e://zzz//11.mp3

		IOUtils.copy(file.getInputStream(), fos);
		
		fos.close();

		// UUID 가 있는거 까지 리턴해줘야 한다.
		return uploadName;
		
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<BoardVO> home(Model model) {
		 
		return  service.showList();
	}
	
	
	@CrossOrigin
	@PostMapping("/register")
	public String writeBoard(BoardVO vo , FileVO fvo){
		
		logger.info("vo: " + vo);
		logger.info("fvo: " + fvo);
		
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

		return "success..";
	}
	
	@CrossOrigin
	@PostMapping("/remove")
	public String removeBoard(Integer num){
		
		service.remove(num);

		return "sucess..";
	}
	
	

}
