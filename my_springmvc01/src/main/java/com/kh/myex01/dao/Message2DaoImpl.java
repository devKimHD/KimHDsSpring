package com.kh.myex01.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myex01.vo.Message2Vo;

@Repository
public class Message2DaoImpl implements Message2Dao {
	private final String NAMESPACE="com.kh.myex01.mappers.message2.";
	@Autowired
	SqlSession sqlSession;
	@Override
	public boolean insertMessage2(Message2Vo message2Vo) {
		int count=sqlSession.insert(NAMESPACE+"insertMessage2",message2Vo);
		if(count >0) {
			return true;
		}
		return false;
	}

	@Override
	public Message2Vo readMessage2(int mid) {
		Message2Vo message2Vo=
				sqlSession.selectOne(NAMESPACE+"readMessage2", mid);
		return message2Vo;
	}

	@Override
	public boolean updateOpendate(int mid) {
		int count=sqlSession.update(NAMESPACE+"updateOpendate", mid);
		if(count >0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteMessage2(int mid) {
		int count=sqlSession.delete(NAMESPACE+"deleteMessage2", mid);
		if(count >0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Message2Vo> message2List(String memberid, String mType) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("memberid", memberid);
		map.put("mType", mType);
		List<Message2Vo> message2List=
				sqlSession.selectList(NAMESPACE+"message2List",map );
		return message2List;
	}

	@Override
	public String getCountNoReadMessage(String receiver) {
		String count=sqlSession.selectOne(NAMESPACE+"getCountNoReadMessage", receiver);
		return count;
	}

}
