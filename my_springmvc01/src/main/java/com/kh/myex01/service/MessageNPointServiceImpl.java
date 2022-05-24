package com.kh.myex01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.myex01.dao.Message2Dao;
import com.kh.myex01.dao.Point2Dao;
import com.kh.myex01.vo.Message2Vo;
import com.kh.myex01.vo.Point2Vo;
@Service
public class MessageNPointServiceImpl implements MessageNPointService{

	@Autowired
	private Message2Dao message2Dao;
	@Autowired
	private Point2Dao point2Dao;
	
	@Transactional
	@Override
	public boolean sendMessage(Message2Vo message2Vo) {
		//메세지 작성
		boolean result1=message2Dao.insertMessage2(message2Vo);
		// 유저 포인트 업데이트
		Point2Vo point2Vo=new Point2Vo
				(message2Vo.getSender(), Point2Dao.SEND_MESSAGE_POINT, Point2Dao.SEND_MESSAGE_CODE);
		boolean result2= point2Dao.updateUserPoint(point2Vo);
		//포인트 내역 추가
		boolean result3= point2Dao.insertPoint(point2Vo);
		if(result1 && result2 && result3) {
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public Message2Vo readMessage(int mid ,Point2Vo point2Vo) {
		//메시지 읽은날 수정
		boolean result1=message2Dao.updateOpendate(mid);
		//유저 포인트 업데이트
		boolean result2=point2Dao.updateUserPoint(point2Vo);
		//포인트 내역 추가
		boolean result3=point2Dao.insertPoint(point2Vo);
		
		if(result1 && result2 && result3) {
			Message2Vo message2Vo=message2Dao.readMessage2(mid);
			return message2Vo;
		}
		return null;
	}

	@Override
	public List<Message2Vo> message2List(String memberid, String mType) {
		List<Message2Vo> message2List=message2Dao.message2List(memberid, mType);
		return message2List;
	}

}
