package com.kh.myex01.dao;

import java.util.List;

import com.kh.myex01.vo.Member2Vo;

public interface Member2Dao {
public String getTime();
public List<Member2Vo> getMember2List();
public Member2Vo getMemberById(String memberid);
public boolean insertMember2(Member2Vo member2Vo);
public boolean modifyMember2(Member2Vo member2Vo);
public boolean deleteMember2(String memberid);
public Member2Vo getMemberByIdnPw(String memberid, String memberpw);
}
