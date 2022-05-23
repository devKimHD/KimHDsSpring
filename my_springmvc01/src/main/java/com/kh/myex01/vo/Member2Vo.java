package com.kh.myex01.vo;

import java.sql.Date;

public class Member2Vo {
	private String memberid;
	private String memberpw;
	private String membername;
	private String email;
	private Date regdate;
	private Date updatedate;
	private int m_point;
	public Member2Vo() {
		super();
	}
	public Member2Vo(String memberid, String memberpw, String membername, String email) {
		super();
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.membername = membername;
		this.email = email;
	}
	public Member2Vo(String memberid, String memberpw, String membername, String email, Date regdate, Date updatedate) {
		super();
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.membername = membername;
		this.email = email;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}
	
	public Member2Vo(String memberid, String memberpw, String membername, String email, Date regdate, Date updatedate,
			int m_point) {
		super();
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.membername = membername;
		this.email = email;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.m_point = m_point;
	}
	
	
	public int getM_point() {
		return m_point;
	}
	public void setM_point(int m_point) {
		this.m_point = m_point;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMemberpw() {
		return memberpw;
	}
	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	@Override
	public String toString() {
		return "Member2Vo [memberid=" + memberid + ", memberpw=" + memberpw + ", membername=" + membername + ", email="
				+ email + ", regdate=" + regdate + ", updatedate=" + updatedate + ", m_point=" + m_point + "]";
	}
	
}
