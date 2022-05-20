package com.kh.myex01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.myex01.service.Board2Service;
import com.kh.myex01.vo.Board2Vo;
import com.kh.myex01.vo.PagingDto;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	@Autowired
	Board2Service board2Service;
	@RequestMapping(value="/list" , method=RequestMethod.GET)
	public String list(Model model,PagingDto pagingDto){
//		if(page <= 0 && Integer.valueOf(page) ==null) {
//			page=1;
//		}
		//searchType keyword ÀúÀåµÈ dto 
		System.out.println("BoardController list, ");
		int count=board2Service.boardCount(pagingDto);
		pagingDto.setCount(count);
		pagingDto.setPage(pagingDto.getPage());
		
		List<Board2Vo> board2List =board2Service.list(pagingDto);
		model.addAttribute("board2List", board2List);
		model.addAttribute("pagingDto", pagingDto);
		return "board/list";
	}
	@RequestMapping(value="/content" , method=RequestMethod.GET)
	public String content(int bno,Model model,PagingDto pagingDto) {
		Board2Vo board2Vo=board2Service.read(bno);
		System.out.println("BoardController content, bno"+ bno);
		System.out.println("BoardController content, board2Vo"+ board2Vo);
		model.addAttribute("board2Vo", board2Vo);
		model.addAttribute("pagingDto", pagingDto);
		return "board/content";
	}
	@RequestMapping(value="/insert_form" , method=RequestMethod.GET)
	public String insert_form() {
		return "board/insert_form";
	}
	@RequestMapping(value="/insert_run" , method=RequestMethod.POST)
	public String insert_run(Board2Vo board2Vo,RedirectAttributes rttr) {
		System.out.println("BoardController insert_run ,board2Vo"+ board2Vo);
		boolean insert_result=board2Service.insert(board2Vo);
		System.out.println("BoardController insert_run ,insert_result :"+ insert_result);
		rttr.addFlashAttribute("insert_result",insert_result);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/update_run" , method=RequestMethod.POST)
	public String update_run(Board2Vo board2Vo,RedirectAttributes rttr,PagingDto pagingDto) {
		System.out.println("BoardController update_run board2Vo"+ board2Vo);
		boolean update_result=board2Service.update(board2Vo);
		rttr.addFlashAttribute("update_result", update_result);
		rttr.addAttribute("page", pagingDto.getPage());
		rttr.addAttribute("perPage", pagingDto.getPerPage());
		rttr.addAttribute("searchType", pagingDto.getSearchType());
		rttr.addAttribute("keyword", pagingDto.getKeyword());
		rttr.addAttribute("bno", board2Vo.getBno());
		return "redirect:/board/content";
	}
	@RequestMapping(value="/delete" , method=RequestMethod.GET)
	public String delete(int bno,RedirectAttributes rttr,PagingDto pagingDto) {
		System.out.println("BoardController delete bno"+ bno);
		boolean delete_result=board2Service.delete(bno);
		rttr.addFlashAttribute("delete_result", delete_result);
		rttr.addAttribute("page",pagingDto.getPage());
		rttr.addAttribute("perPage",pagingDto.getPerPage());
		rttr.addAttribute("searchType", pagingDto.getSearchType());
		rttr.addAttribute("keyword", pagingDto.getKeyword());
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/reply_form" , method=RequestMethod.GET)
	public String replyForm(int bno,Model model,RedirectAttributes rttr,PagingDto pagingDto) {
		System.out.println("BoardController replyForm bno"+ bno);
		Board2Vo board2Vo=board2Service.read(bno);
		model.addAttribute("board2Vo", board2Vo);
		rttr.addAttribute("page",pagingDto.getPage());
		rttr.addAttribute("perPage",pagingDto.getPerPage());
		rttr.addAttribute("searchType", pagingDto.getSearchType());
		rttr.addAttribute("keyword", pagingDto.getKeyword());
		return "board/reply_form";
	}
	
	@RequestMapping(value="/reply_run" , method=RequestMethod.POST)
	public String replyForm(Board2Vo board2Vo,RedirectAttributes rttr,PagingDto pagingDto) {
		System.out.println("BoardController reply_run board2Vo"+ board2Vo);
		boolean reply_result=board2Service.insertReply(board2Vo);
		//rttr.addAttribute("bno", board2Vo.getBno());
		rttr.addAttribute("page",pagingDto.getPage());
		rttr.addAttribute("perPage",pagingDto.getPerPage());
		rttr.addAttribute("searchType", pagingDto.getSearchType());
		rttr.addAttribute("keyword", pagingDto.getKeyword());
		rttr.addFlashAttribute("reply_result", reply_result);
		return "redirect:/board/list";
	}
}
