package com.kh.myex01.vo;

import java.sql.Date;

public class Comment2Vo {
	private int cno;
	private int bno;
	private String content;
	private String user_id;
	private Date regdate;
	public Comment2Vo() {
		super();
	}
	public Comment2Vo(int cno, int bno, String content, String user_id) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.content = content;
		this.user_id = user_id;
	}
	public Comment2Vo(int cno, int bno, String content, String user_id, Date regdate) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.content = content;
		this.user_id = user_id;
		this.regdate = regdate;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Comment2Vo [cno=" + cno + ", bno=" + bno + ", content=" + content + ", user_id=" + user_id
				+ ", regdate=" + regdate + "]";
	}
	
	
}
