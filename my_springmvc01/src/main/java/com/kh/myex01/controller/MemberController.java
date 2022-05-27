package com.kh.myex01.controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.myex01.service.Member2Service;
import com.kh.myex01.service.MessageNPointService;
import com.kh.myex01.util.FileuploadUtil;
import com.kh.myex01.vo.Member2Vo;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private Member2Service member2Service;
	@Autowired
	private MessageNPointService messageService;
	@RequestMapping(value="/getUserById", method=RequestMethod.GET)
	public String getUserById(String memberid, Model model ) {
		Member2Vo member2Vo=member2Service.getMemberById(memberid);
		System.out.println("MemberController getUserById member2Vo"+member2Vo);
		model.addAttribute("member2Vo", member2Vo);
		return "member/info";
	}
	
	@RequestMapping(value="/join_form", method=RequestMethod.GET)
	public String joinForm() {
		return "member/join_form";
	}
	
	@RequestMapping(value="/join_run", method=RequestMethod.POST)
	public String joinRun(Member2Vo member2Vo,MultipartFile file) {
		System.out.println("MemberController joinRun Member2Vo "+member2Vo);
		String originalFilename=file.getOriginalFilename();
		long size=file.getSize();
		String path="c:/myspring";
		System.out.println("MemberController joinRun MultipartFile "+file);
		System.out.println("MemberController joinRun orinalFilename "+originalFilename);
		System.out.println("MemberController joinRun size "+size);
		try {
			String m_pic=
					FileuploadUtil.uploadFile(path, originalFilename, file.getBytes());
			member2Vo.setM_pic(m_pic);
			member2Service.insertMember2(member2Vo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/login_run", method=RequestMethod.POST)
	public String loginRun(String memberid,String memberpw,HttpSession session,RedirectAttributes rttr) {
		
		String returnURL="redirect:/";
		Member2Vo loginVo=member2Service.getMemberByIdnPw(memberid, memberpw);
		if(loginVo ==null) {
			rttr.addFlashAttribute("login_result", "fail");
			return returnURL;
		}
		else {
			session.setAttribute("loginVo", loginVo);
			String msgNoReadCount=messageService.getCountNoReadMessage(memberid);
			session.setAttribute("msgNoReadCount",msgNoReadCount);
			return returnURL+"board/list";	
		}
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/getProfile", method=RequestMethod.GET)
	@ResponseBody
	public byte[] getProfile(String filename) throws IOException {
		System.out.println("MemberController joinRun getProfile "+filename);
		FileInputStream fis=new FileInputStream(filename);
		byte[] data=IOUtils.toByteArray(fis);
		return data;
	}
}
