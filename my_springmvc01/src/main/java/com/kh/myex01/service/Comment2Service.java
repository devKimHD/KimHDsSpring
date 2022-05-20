package com.kh.myex01.service;

import java.util.List;

import com.kh.myex01.vo.Comment2Vo;

public interface Comment2Service {
	public boolean commentInsert(Comment2Vo comment2Vo);
	public List<Comment2Vo> commentList(int bno);
	public boolean commentUpdate(Comment2Vo comment2Vo);
	public boolean commentDelete(int cno);
}
