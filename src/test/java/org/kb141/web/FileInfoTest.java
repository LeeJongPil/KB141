package org.kb141.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class FileInfoTest {
	
	public String filePath;
	public Mp3File songData;
	
	@Before
	public void set() throws Exception {
		filePath = "C:\\zzz\\leessang.mp3";
		songData = new Mp3File(filePath);
		
//		songData = new mp3
	}
	
	@Test
	public void mp3InfoTest() throws Exception{
		
		ID3v2 songTags = songData.getId3v2Tag();
		System.out.println(songTags.getArtist());
		
		System.out.println("TEST : " + songTags.getEncoder());
		
		System.out.println( new String(songTags.getArtist().getBytes("ISO-8859-1"),"EUC-KR"));
		
		System.out.println(songTags.getTitle());
		
		
		
		System.out.println(songTags.getAlbum());
		System.out.println(songTags.getYear());
		
	}
	
	
	
	
}
