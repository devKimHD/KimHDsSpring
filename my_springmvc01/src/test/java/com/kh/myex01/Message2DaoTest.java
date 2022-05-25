package com.kh.myex01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.myex01.dao.Message2Dao;
import com.kh.myex01.vo.Message2Vo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class Message2DaoTest {
	@Autowired
	private Message2Dao message2Dao;
	
	@Test
	public void insertMessage2() {
		for(int i=1; i<=10; i++) {
			Message2Vo message2Vo=new Message2Vo("user02", "user01", "user02 to user01"+i); 
			boolean result =message2Dao.insertMessage2(message2Vo);
			System.out.println("insertMessage2 "+result);
		}
		
	}
	
	@Test
	public void readMessage2() {
		Message2Vo message2Vo=message2Dao.readMessage2(1);
		System.out.println("readMessage2 "+ message2Vo);
	}
	
	@Test
	public void updateMessage2() {
		boolean result=message2Dao.updateOpendate(1);
		System.out.println("updateMessage2 "+result);
	}
	@Test
	public void deleteMessage2() {
		boolean result=message2Dao.deleteMessage2(1);
		System.out.println("deleteMessage2 "+result);
	}
	
	@Test
	public void message2List() {
		List<Message2Vo> message2List
			=message2Dao.message2List("user01", "receiver");
		for(Message2Vo me2Vo:message2List)
		System.out.println("message2List "+me2Vo);
	}
	
	@Test
	public void message2NoRead() {
		String count=message2Dao.getCountNoReadMessage("user01");
		System.out.println(count);
	}
}
