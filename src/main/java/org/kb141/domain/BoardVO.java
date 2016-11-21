package org.kb141.domain;

public class BoardVO {

	private String btitle;
	private String bcontent;
	private String bwriter;
	private String bsong;
	private String bsinger;

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

	@Override
	public String toString() {
		return "boardVO [btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter + ", bsong=" + bsong
				+ ", bsinger=" + bsinger + "]";
	}

}
