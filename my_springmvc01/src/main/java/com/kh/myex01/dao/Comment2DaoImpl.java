package com.kh.myex01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myex01.vo.Comment2Vo;

@Repository
public class Comment2DaoImpl implements Comment2Dao {
	private final String NAMESPACE="com.kh.myex01.mappers.comment2.";
	@Autowired
	private SqlSession sqlSession;
	@Override
	public boolean commentInsert(Comment2Vo comment2Vo) {
		int count=sqlSession.insert(NAMESPACE+"commentInsert", comment2Vo);
		if(count >0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Comment2Vo> commentList(int bno) {
		List<Comment2Vo> commentList = sqlSession.selectList(NAMESPACE+"commentList", bno);
		return commentList;
	}
	@Override
	public boolean commentUpdate(Comment2Vo comment2Vo) {
		int count=sqlSession.update(NAMESPACE+"commentUpdate", comment2Vo);
		if(count >0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean commentDelete(int cno) {
		int count=sqlSession.delete(NAMESPACE+"commentDelete", cno);
		if(count >0) {
			return true;
		}
		return false;
	}

}
