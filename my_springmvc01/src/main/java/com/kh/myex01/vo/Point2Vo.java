package com.kh.myex01.vo;

import java.sql.Date;

public class Point2Vo {
	private int pid;
	private String memberid;
	private int point;
	private int pcode;
	private Date pointdate;
	
	public Point2Vo() {
		super();
	}

	

	public Point2Vo(String memberid, int point, int pcode) {
		super();
		this.memberid = memberid;
		this.point = point;
		this.pcode = pcode;
	}



	public Point2Vo(int pid, String memberid, int point, int pcode, Date pointdate) {
		super();
		this.pid = pid;
		this.memberid = memberid;
		this.point = point;
		this.pcode = pcode;
		this.pointdate = pointdate;
	}



	public String getMemberid() {
		return memberid;
	}



	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}



	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}


	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public Date getPointdate() {
		return pointdate;
	}

	public void setPointdate(Date pointdate) {
		this.pointdate = pointdate;
	}



	@Override
	public String toString() {
		return "Point2Vo [pid=" + pid + ", memberid=" + memberid + ", point=" + point + ", pcode=" + pcode
				+ ", pointdate=" + pointdate + "]";
	}

	
	
	
}
