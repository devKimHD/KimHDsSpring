package com.kh.myex01.dao;

import java.util.List;

import com.kh.myex01.vo.Board2Vo;
import com.kh.myex01.vo.PagingDto;

public interface Board2Dao {
public boolean insert(Board2Vo board2Vo);
public List<Board2Vo> list(PagingDto pagingDto);
public Board2Vo read(int bno);
public boolean update(Board2Vo board2Vo);
public boolean delete(int bno);
public int boardCount(PagingDto pagingDto);
public boolean insertReply(Board2Vo board2Vo);
public void updateReply(Board2Vo board2Vo);
public void updateViewCnt(int bno);
public void insertFile(String filename,int bno);
public int getNextBno();
}
