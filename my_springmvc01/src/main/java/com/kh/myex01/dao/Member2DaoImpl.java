package com.kh.myex01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myex01.vo.Member2Vo;

@Repository
public class Member2DaoImpl implements Member2Dao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kh.myex01.mappers.member2.";
	@Override
	public String getTime() {
		String time=sqlSession.selectOne(NAMESPACE+"getTime");
		return time;
	}
	@Override
	public List<Member2Vo> getMember2List() {
		List<Member2Vo> member2List=sqlSession.selectList(NAMESPACE+"getMember2List");
		return member2List;
	}
	@Override
	public Member2Vo getMemberById(String memberid) {
		Member2Vo member2Vo=sqlSession.selectOne(NAMESPACE+"getMemberById", memberid);
		return member2Vo;
	}
	@Override
	public boolean insertMember2(Member2Vo member2Vo) {
			int count=sqlSession.insert(NAMESPACE+"insertMember2", member2Vo);
			if(count>0) {
				return true;
			}
		return false;
	}
	@Override
	public boolean modifyMember2(Member2Vo member2Vo) {
			int count=sqlSession.update(NAMESPACE+"modifyMember2", member2Vo);
			if(count >0) {
				return true;
			}
		return false;
	}
	@Override
	public boolean deleteMember2(String memberid) {
		int count=sqlSession.delete(NAMESPACE+"deleteMember2", memberid);
		if(count >0) {
			return true;
		}
		return false;
	}
	
	
}
