package com.kh.myex01.dao;

import java.util.List;

import com.kh.myex01.vo.Message2Vo;

public interface Message2Dao {
	public boolean insertMessage2(Message2Vo message2Vo);
	public Message2Vo readMessage2(int mid);
	public boolean updateOpendate(int mid);
	public boolean deleteMessage2(int mid);
	public List<Message2Vo> message2List(String memberid,String mType);
}
