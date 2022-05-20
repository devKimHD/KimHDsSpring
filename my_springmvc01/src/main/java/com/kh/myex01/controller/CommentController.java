package com.kh.myex01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kh.myex01.service.Comment2Service;
import com.kh.myex01.vo.Comment2Vo;

@RestController
//모든 요청에 대해 데이터 반환
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private Comment2Service comment2Service;
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "HELLO";
	}
	@RequestMapping(value="/commentInsert", method=RequestMethod.POST)
	public String commentInsert(Comment2Vo comment2Vo) {
		boolean result=comment2Service.commentInsert(comment2Vo);
		return String.valueOf(result);
	}
	@RequestMapping(value="/commentList/{bno}", method=RequestMethod.GET)
	public List<Comment2Vo> commentList(@PathVariable("bno") int bno){
		System.out.println("Comment2Service commentList , bno"+bno);
		List<Comment2Vo> commentList=comment2Service.commentList(bno);
		System.out.println("Comment2Service commentList , commentList"+commentList);
		return commentList;
	}
	@RequestMapping(value="/commentDelete/{cno}", method=RequestMethod.GET)
	public String commentDelete(@PathVariable int cno) {
		boolean result=comment2Service.commentDelete(cno);
		return String.valueOf(result);
		}
	@RequestMapping(value="/commentUpdate", method=RequestMethod.POST)
	public String commentUpdate(Comment2Vo comment2Vo) {
		boolean result=comment2Service.commentUpdate(comment2Vo);
		return String.valueOf(result);
	}

//
}
