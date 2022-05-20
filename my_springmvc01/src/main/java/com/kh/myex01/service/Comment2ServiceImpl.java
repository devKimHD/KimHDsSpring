package com.kh.myex01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.myex01.dao.Comment2Dao;
import com.kh.myex01.vo.Comment2Vo;
@Service
public class Comment2ServiceImpl implements Comment2Service {
	@Autowired
	private Comment2Dao comment2Dao;
	@Override
	public boolean commentInsert(Comment2Vo comment2Vo) {
		return comment2Dao.commentInsert(comment2Vo);
	}

	@Override
	public List<Comment2Vo> commentList(int bno) {
		return comment2Dao.commentList(bno);
	}

	@Override
	public boolean commentUpdate(Comment2Vo comment2Vo) {
		return comment2Dao.commentUpdate(comment2Vo);
	}

	@Override
	public boolean commentDelete(int cno) {
		return comment2Dao.commentDelete(cno);
	}

}
