package com.kh.myex01.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myex01.vo.Board2Vo;
import com.kh.myex01.vo.PagingDto;

@Repository
public class Board2DaoImpl implements Board2Dao {
	@Autowired
	SqlSession sqlSession;
	private final String NAMESPACE = "com.kh.myex01.mappers.board2.";

	@Override
	public boolean insert(Board2Vo board2Vo) {
		int count = sqlSession.insert(NAMESPACE + "insert", board2Vo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Board2Vo> list(PagingDto pagingDto ) {
		List<Board2Vo> board2List = sqlSession.selectList(NAMESPACE + "list",pagingDto);
		return board2List;
	}

	@Override
	public Board2Vo read(int bno) {
		Board2Vo board2Vo=sqlSession.selectOne(NAMESPACE+"read", bno);
		return board2Vo;
	}

	@Override
	public boolean update(Board2Vo board2Vo) {
		int count =sqlSession.update(NAMESPACE+"update", board2Vo);
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int bno) {
		int count = sqlSession.delete(NAMESPACE+"delete",bno);
		if(count >0) {
			return true;
		}
		return false;
	}

	@Override
	public int boardCount(PagingDto pagingDto) {
		String str_count=sqlSession.selectOne(NAMESPACE+"boardCount",pagingDto);
		int count=Integer.parseInt(str_count);
		return count;
	}

	@Override
	public boolean insertReply(Board2Vo board2Vo) {
		int count=sqlSession.insert(NAMESPACE+"insertReply", board2Vo);
		if(count >0) {
			return true;
		}
		return false;
	}

	@Override
	public void updateReply(Board2Vo board2Vo) {
		sqlSession.update(NAMESPACE+"updateReply", board2Vo);
	}

	@Override
	public void updateViewCnt(int bno) {
		sqlSession.update(NAMESPACE+"updateViewCnt", bno);
	}

	@Override
	public void insertFile(String filename, int bno) {
		Map<String, Object> parameter=new HashMap<String, Object>();
		parameter.put("filename", filename);
		parameter.put("bno", bno);
		sqlSession.insert(NAMESPACE+"insertFile", parameter);
	}

	@Override
	public int getNextBno() {
		int bno=sqlSession.selectOne(NAMESPACE+"getNextBno");
		return bno;
	}

}
