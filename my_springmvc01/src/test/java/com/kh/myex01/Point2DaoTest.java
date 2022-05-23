package com.kh.myex01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.myex01.dao.Point2Dao;
import com.kh.myex01.service.MessageNPointService;
import com.kh.myex01.vo.Message2Vo;
import com.kh.myex01.vo.Point2Vo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class Point2DaoTest {
	@Autowired
	private MessageNPointService messageNPointService;
	
	@Test
	public void testSendMessage() {
		Message2Vo message2Vo = new Message2Vo("user01", "user02", "point up test2 send user01 to user03");
		boolean result=messageNPointService.sendMessage(message2Vo);
		System.out.println("testSendMessage "+result);
		
	}
	@Test
	public void testReadMessage() {
		int mid=22;
		Point2Vo point2Vo=new Point2Vo();
		
		point2Vo.setMemberid("user02");
		point2Vo.setPoint(Point2Dao.READ_MESSAGE_POINT);
		point2Vo.setPcode(Point2Dao.READ_MESSAGE_CODE);
		
		Message2Vo message2Vo=
				messageNPointService.readMessage(mid, point2Vo);
		System.out.println("testReadMessage "+message2Vo);
	}
	
	
}
