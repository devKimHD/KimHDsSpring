package com.kh.myex01.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.myex01.service.MessageNPointService;
import com.kh.myex01.vo.Member2Vo;
import com.kh.myex01.vo.Message2Vo;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	MessageNPointService messageService;
	
	@RequestMapping(value="/receive", method=RequestMethod.GET)
	public String receiveMessageList(HttpSession session,Model model) {
		Member2Vo member2Vo=(Member2Vo)session.getAttribute("loginVo");
		List<Message2Vo> message2List=messageService.message2List(member2Vo.getMemberid(), MessageNPointService.TYPE_RECEIVE);
		model.addAttribute("message2List", message2List);	
		return "message/receiveList";
	}
	
	@RequestMapping(value="/send", method=RequestMethod.GET)
	public String sendMessageList(HttpSession session,Model model) {
		Member2Vo member2Vo=(Member2Vo)session.getAttribute("loginVo");
		List<Message2Vo> message2List=messageService.message2List(member2Vo.getMemberid(), MessageNPointService.TYPE_SEND);
		model.addAttribute("message2List", message2List);	
		return "message/sendList";
	}
	
}
