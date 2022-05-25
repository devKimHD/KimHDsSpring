package com.kh.myex01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.myex01.dao.Board2Dao;
import com.kh.myex01.vo.Board2Vo;
import com.kh.myex01.vo.PagingDto;

@Service
public class Board2ServiceImpl implements Board2Service{
	@Autowired
	private Board2Dao board2Dao;
	@Override
	public boolean insert(Board2Vo board2Vo) {
		boolean result=board2Dao.insert(board2Vo);
		return result;
	}

	@Override
	public List<Board2Vo> list(PagingDto pagingDto) {
		 List<Board2Vo> list=board2Dao.list(pagingDto);
		return list;
	}

	@Override
	public Board2Vo read(int bno) {
		Board2Vo board2Vo=board2Dao.read(bno);
		return board2Vo;
	}

	@Override
	public boolean update(Board2Vo board2Vo) {
		boolean result=board2Dao.update(board2Vo);
		return result;
	}

	@Override
	public boolean delete(int bno) {
		boolean result=board2Dao.delete(bno);
		return result;
	}

	@Override
	public int boardCount(PagingDto pagingDto) {
		int count=board2Dao.boardCount(pagingDto);
		return count;
	}

	@Override
	@Transactional
	public boolean insertReply(Board2Vo board2Vo) {
		board2Dao.updateReply(board2Vo);
		boolean result=board2Dao.insertReply(board2Vo);
		return result;
	}

	@Override
	public void updateViewCnt(int bno) {
		board2Dao.updateViewCnt(bno);
	}

	

}
