package org.kb141.domain;

public class FileVO {
		
	
	private Integer bno;
	private String bfile;
	
	public FileVO() {
		super();	
	}
	
	
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	@Override
	public String toString() {
		return "FileVO [bno=" + bno + ", bfile=" + bfile + "]";
	}
	
	
}
