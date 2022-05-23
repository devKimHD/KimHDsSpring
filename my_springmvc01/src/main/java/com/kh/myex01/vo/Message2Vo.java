package com.kh.myex01.vo;

import java.sql.Date;

public class Message2Vo {
	private int mid;
	private String sender;
	private String receiver;
	private String message;
	private Date senddate;
	private Date opendate;
	public Message2Vo() {
		super();
	}
	public Message2Vo(String sender, String receiver, String message) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}
	public Message2Vo(int mid, String sender, String receiver, String message, Date senddate, Date opendate) {
		super();
		this.mid = mid;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.senddate = senddate;
		this.opendate = opendate;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSenddate() {
		return senddate;
	}
	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	@Override
	public String toString() {
		return "Message2Vo [mid=" + mid + ", sender=" + sender + ", receiver=" + receiver + ", message=" + message
				+ ", senddate=" + senddate + ", opendate=" + opendate + "]";
	}
	
}
