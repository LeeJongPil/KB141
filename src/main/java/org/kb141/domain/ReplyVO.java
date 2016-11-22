package org.kb141.domain;

import java.util.Date;

public class ReplyVO {
		
	
	private Integer rno,bno;
	private String rwrite,rcontent;
	private Date regdate, updatadate;
	
	public ReplyVO() {
		super();
	}
	


	public ReplyVO(Integer bno, String rwrite, String rcontent) {
		super();
		this.bno = bno;
		this.rwrite = rwrite;
		this.rcontent = rcontent;
	}



	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getRwrite() {
		return rwrite;
	}
	public void setRwrite(String rwrite) {
		this.rwrite = rwrite;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatadate() {
		return updatadate;
	}
	public void setUpdatadate(Date updatadate) {
		this.updatadate = updatadate;
	}
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", bno=" + bno + ", rwrite=" + rwrite + ", rcontent=" + rcontent + ", regdate="
				+ regdate + ", updatadate=" + updatadate + "]";
	}
	
}
