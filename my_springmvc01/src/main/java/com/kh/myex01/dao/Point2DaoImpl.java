package com.kh.myex01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myex01.vo.Point2Vo;
@Repository
public class Point2DaoImpl implements Point2Dao {

	private final String NAMESPACE="com.kh.myex01.mappers.point.";
	@Autowired
	private SqlSession sqlSession;
	@Override
	public boolean insertPoint(Point2Vo point2Vo) {
		int count=sqlSession.insert(NAMESPACE+"insertPoint", point2Vo);
		if(count >0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUserPoint(Point2Vo point2Vo) {
		int count=sqlSession.update(NAMESPACE+"updateUserPoint", point2Vo);
		if(count >0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePoint(int pid) {
		int count= sqlSession.delete(NAMESPACE+"deletePoint", pid);
		if(count >0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Point2Vo> pointList(String memberid) {
		List<Point2Vo> pointList=
				sqlSession.selectList(NAMESPACE+"pointList", memberid);
		return pointList;
	}

}
