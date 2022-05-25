package com.kh.myex01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.myex01.dao.Member2Dao;
import com.kh.myex01.vo.Member2Vo;
@Service
public class Member2ServiceImpl implements Member2Service {
	@Autowired
	Member2Dao member2Dao;
	@Override
	public List<Member2Vo> getMember2List() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member2Vo getMemberById(String memberid) {
		Member2Vo loginVo=member2Dao.getMemberById(memberid);
		return loginVo;
	}

	@Override
	public boolean insertMember2(Member2Vo member2Vo) {
		boolean result=member2Dao.insertMember2(member2Vo);
		return result;
	}

	@Override
	public boolean modifyMember2(Member2Vo member2Vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMember2(String memberid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member2Vo getMemberByIdnPw(String memberid, String memberpw) {
		Member2Vo member2Vo=member2Dao.getMemberByIdnPw(memberid, memberpw);
		return member2Vo;
	}

}
