package com.kh.myex01;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.myex01.dao.Board2Dao;
import com.kh.myex01.vo.Board2Vo;
import com.kh.myex01.vo.PagingDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class Board2DaoTest {
	@Autowired
	private Board2Dao board2Dao;
//	@Test
//	public void testInsert500() {
//		for(int i=1; i<=500; i++) {
//			Board2Vo board2Vo=new Board2Vo("title"+i, "content"+i, "kimhd");
//			board2Dao.insert(board2Vo);
//		}
//	}
	
	@Test
	public void testPaging() {
		PagingDto pagingDto= new PagingDto();
		pagingDto.setPage(2);
		System.out.println("Board2DaoTest testPaging "+pagingDto);
	}
	@Test
	public void testInsert() {
		Board2Vo board2Vo=new Board2Vo("力格-2", null, "kimhd");
		boolean result=board2Dao.insert(board2Vo);
		System.out.println("insert_result "+result);
	}
	@Test
	public void testList() {
		PagingDto pagingDto=new PagingDto();
		pagingDto.setPage(2);
		List<Board2Vo> board2List =board2Dao.list(pagingDto);
		System.out.println("board2List : "+board2List);
	}
	@Test
	public void testRead() {
		Board2Vo board2Vo=board2Dao.read(1);
		System.out.println("board2Vo : "+board2Vo);
	}
	@Test
	public void testUpdate() {
		Board2Vo board2Vo= new Board2Vo("力格-1-荐沥2",null, "hdkim");
		board2Vo.setBno(1);
		boolean result=board2Dao.update(board2Vo);
		System.out.println("update_result : "+result);
	}
	@Test
	public void testDelete() {
		boolean result=board2Dao.delete(2);
		System.out.println("delete_result : "+result);
	}
	@Test
	public void testboardCount() {
		PagingDto pagingDto=new PagingDto();
		pagingDto.setPage(2);
		int count=board2Dao.boardCount(pagingDto);
		System.out.println("testboardCount count"+count);
	}
}
