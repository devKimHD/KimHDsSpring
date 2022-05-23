package com.kh.myex01.service;

import com.kh.myex01.vo.Message2Vo;
import com.kh.myex01.vo.Point2Vo;

public interface MessageNPointService {
	public boolean sendMessage(Message2Vo message2Vo);
	public Message2Vo readMessage(int mid,Point2Vo point2Vo);
}
