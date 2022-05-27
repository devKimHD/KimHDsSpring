package com.kh.myex01;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.myex01.service.Member2Service;
import com.kh.myex01.service.MessageNPointService;
import com.kh.myex01.vo.Member2Vo;


@Controller
public class HomeController {
	@Autowired
	private Member2Service member2Service;
	@Autowired
	private MessageNPointService messageService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session) {
		//user 01 login test
//		Member2Vo loginVo=member2Service.getMemberById("user01");
		
//		session.setAttribute("loginVo",loginVo);
		session.invalidate();
		return "home";
	}
	
}
