package com.kh.myex01.service;

import java.util.List;

import com.kh.myex01.vo.Message2Vo;
import com.kh.myex01.vo.Point2Vo;

public interface MessageNPointService {
	
	public static final String TYPE_SEND="sender";
	public static final String TYPE_RECEIVE="receiver";
	public boolean sendMessage(Message2Vo message2Vo);
	public Message2Vo readMessage(int mid,Point2Vo point2Vo);
	public List<Message2Vo> message2List(String memberid,String mType);
	public String getCountNoReadMessage(String receiver);
}
