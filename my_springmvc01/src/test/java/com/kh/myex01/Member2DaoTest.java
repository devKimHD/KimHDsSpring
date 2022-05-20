package com.kh.myex01;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.myex01.dao.Member2Dao;
import com.kh.myex01.vo.Member2Vo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class Member2DaoTest {
	@Autowired
	Member2Dao member2Dao;
	@Test
	public void testGetTime() {
		String time=member2Dao.getTime();
		System.out.println(time);
	}
	@Test
	public void testMemberInsert() {
		Member2Vo member2Vo=new Member2Vo("user02", "4567", "¿Ã±Êµø", "leegildong@email.com");
		boolean insert_result=member2Dao.insertMember2(member2Vo);
		System.out.println("insert_result " +insert_result);
	}
	@Test
	public void testGetMember2List() {
		List<Member2Vo> member2List=member2Dao.getMember2List();
		System.out.println(member2List);
	}
	@Test
	public void testGetMember2ById() {
		Member2Vo member2Vo=member2Dao.getMemberById("user01");
		System.out.println("member2Vo :"+member2Vo);
	}
	@Test
	public void testUpdateMember2() {
		Member2Vo member2Vo=new Member2Vo("user01", "pw_user", "∞®±√à‘", "gamgum@email.com");
		boolean result=member2Dao.modifyMember2(member2Vo);
		System.out.println("result: "+result);
	}
	@Test
	public void testDeleteMember2() {
		boolean result=member2Dao.deleteMember2("user02");
		System.out.println("result :"+result);
	}
}
