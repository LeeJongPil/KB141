package org.kb141.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.kb141.domain.BoardVO;
import org.kb141.domain.FileVO;
import org.kb141.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

@CrossOrigin
@RestController
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;

	@CrossOrigin
	@PostMapping(value = "/uploadFile", produces = "application/json; charset=utf-8")
	@ResponseBody // ���� �̸��� jsp �����Ű�� ����, ���� ���� �ִ� �� ������
					// ���ڿ��̶�� ��.
	public ID3v2 uploadFile(MultipartFile file) throws Exception {
		// spring�� ������ �����Ͱ� multipart �����͸� �ڵ����� ó���� �ش�.
		// ���� ajax�ε� �� �����ҷ�? json or text
		// UUID ���� ���ϸ��� show�� ������.
		logger.info("fileName : " + file.getOriginalFilename());

		UUID uid = UUID.randomUUID();

		String fileName = new String(file.getOriginalFilename().getBytes("UTF-8"), "UTF-8"); // �����̸�

		String uploadName = uid + "_" + fileName;

		// uploadName -> uid
		String filePath = "E:\\zzz\\mp3server\\" + uid + ".mp3";

		System.out.println(filePath);

		FileOutputStream fos = new FileOutputStream(filePath);

		IOUtils.copy(file.getInputStream(), fos);

		fos.close();

		Mp3File songData = new Mp3File(filePath);

		ID3v2 songTags = songData.getId3v2Tag();

		songTags.getAlbumImage(); // byte[] �̹�����
		String imgPath = filePath.substring(0, filePath.length() - 4) + ".jpg";
		System.out.println(imgPath);

		logger.info(songTags.getArtist());

		songTags.setItunesComment(uid + "");

		FileUtils.writeByteArrayToFile(new File(imgPath), songTags.getAlbumImage());

		return songTags;
	}

	@CrossOrigin
	@GetMapping(value = "/getimage", produces = { "image/jpg" })
	public @ResponseBody byte[] download(String name) throws Exception {
		InputStream in = new FileInputStream("E:\\zzz\\mp3server\\" + name + ".jpg");

		return IOUtils.toByteArray(in);
	}

	@CrossOrigin
	@GetMapping(value = "/getmp3", produces = { "audio/mpeg" })
	public @ResponseBody byte[] downloadMp3(String name) throws Exception {
		InputStream in = new FileInputStream("E:\\zzz\\mp3server\\" + name + ".mp3");

		return IOUtils.toByteArray(in);
	}

	@CrossOrigin // 리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<BoardVO> home(Model model) {

		return service.showList();
	}

	@CrossOrigin
	@PostMapping("/register") // 등록하기
	public String writeBoard(BoardVO vo, FileVO fvo) {

		logger.info("vo: " + vo);
		logger.info("fvo: " + fvo);

		service.register(vo, fvo);
		return "sucess..";
	}

	@CrossOrigin // 뷰화면
	@PostMapping(value = "/view", produces = "application/json; charset=utf-8")
	public BoardVO viewBoard(String bno, Model model) {
		BoardVO vo = new BoardVO();

		logger.info(bno);
		int no = Integer.parseInt(bno);

		return service.view(no);
	}

	@CrossOrigin // 뷰화면
	@PostMapping(value = "/directMusic", produces = "plain/text; charset=utf-8")
	public String directSong(String bno, Model model) {
		BoardVO vo = new BoardVO();

		logger.info(bno);
		int no = Integer.parseInt(bno);

		vo = service.view(no);

		vo.getBfile();

		return vo.getBfile();
	}

	@CrossOrigin // 수정하기
	@PostMapping("/modify")
	public String modifyBoard(BoardVO vo) {

		service.modify(vo);
		logger.info("modify......" + vo);

		return "success..";
	}

	@CrossOrigin // 삭제하기
	@PostMapping("/remove")
	public String removeBoard(String bno, Model model) {
		// bno로 bfile 가지고 오고,

		logger.info(bno);

		int num = Integer.parseInt(bno);
		String fileName = service.getFileName(num);
		service.remove(num);
		File delJpgFile = new File("E:\\zzz\\mp3server\\" + fileName + ".jpg");
		File delMp3File = new File("E:\\zzz\\mp3server\\" + fileName + ".mp3");

		delMp3File.delete(); 
		delJpgFile.delete();

			return "success";
	}
}
