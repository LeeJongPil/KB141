package org.kb141.domain;

import java.util.Date;

public class BoardVO {

	private Integer bno, bcnt;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private String bsong;
	private String bsinger;
	private Date regdate, updatedate;

	private String bfile;
	
	public BoardVO(){
		super();
	}
	
	
	public BoardVO(String btitle, String bcontent, String bwriter, String bsong, String bsinger) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bsong = bsong;
		this.bsinger = bsinger;
	}

	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public Integer getBcnt() {
		return bcnt;
	}

	public void setBcnt(Integer bcnt) {
		this.bcnt = bcnt;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBsong() {
		return bsong;
	}

	public void setBsong(String bsong) {
		this.bsong = bsong;
	}

	public String getBsinger() {
		return bsinger;
	}

	public void setBsinger(String bsinger) {
		this.bsinger = bsinger;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	




	public String getBfile() {
		return bfile;
	}


	public void setBfile(String bfile) {
		this.bfile = bfile;
	}


	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", bcnt=" + bcnt + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter="
				+ bwriter + ", bsong=" + bsong + ", bsinger=" + bsinger + ", regdate=" + regdate + ", updatedate="
				+ updatedate + ", bfile=" + bfile + "]";
	}



}
