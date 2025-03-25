package com.oneyo.spring.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oneyo.spring.board.domain.ReplyVO;
import com.oneyo.spring.board.service.ReplyService;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService rService;
	
	public ReplyController(ReplyService rService) {
		this.rService = rService;
	}
	
	// 댓글 등록
	@PostMapping("/replyInsert")
	public String showReplyInsert(@ModelAttribute ReplyVO reply,
				@RequestParam("boardNo")int boardNo,
				HttpSession session, Model model) {
		try {
			String memberId = (String)session.getAttribute("memberId");
			String memberNickname = rService.getMemberNickname(memberId);
			session.setAttribute("memberNickname", memberNickname);
			reply.setMemberId(memberId);
			reply.setMemberNickname(memberNickname);
			reply.setBoardNo(boardNo);
			
			int result = rService.insertReply(reply);
			
			return "redirect:/board/detail/" + boardNo;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
	// 댓글 삭제
	@GetMapping("/replyDelete")
	public String deleteReply(@RequestParam("boardNo")int boardNo,
			@RequestParam("replyNo")int replyNo, Model model) {
		try {
			int result = rService.deleteReply(replyNo);
			return "redirect:/board/detail/" + boardNo;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
}
