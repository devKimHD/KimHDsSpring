package com.kh.myex01.dao;

import java.util.List;

import com.kh.myex01.vo.Point2Vo;

public interface Point2Dao {
	public static final int SEND_MESSAGE_POINT=10;
	public static final int READ_MESSAGE_POINT=5;
	public static final int SEND_MESSAGE_CODE=1001;
	public static final int READ_MESSAGE_CODE=1002;
	public boolean insertPoint(Point2Vo point2Vo);
	public boolean updateUserPoint(Point2Vo point2Vo);
	public boolean deletePoint(int pid);
	public List<Point2Vo> pointList(String memberid);
}
