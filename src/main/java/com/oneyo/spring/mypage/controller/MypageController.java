package com.oneyo.spring.mypage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oneyo.spring.common.PageUtill;
import com.oneyo.spring.mypage.domain.MyBoardVO;
import com.oneyo.spring.mypage.domain.MyReplyVO;
import com.oneyo.spring.mypage.domain.MySourceList;
import com.oneyo.spring.mypage.service.MypageService;

@Controller
public class MypageController {
	
	@Autowired
	private MypageService mService;
	@Autowired
	private PageUtill pageUtil;
	
//	@GetMapping("/mypage")
//	public String showMypageMain(Model model) {	
//		try {
//			List<MySourceList> mList = mService.selectSourceList();
//			return "/mypage";
//		} catch (Exception e) {
//		}
//		return "mypage/mypage";
//	}
	@GetMapping("/mypage/myBoard")
	public String showMyBoard(@RequestParam(value="currentPage", defaultValue="1")		
	int currentPage, Model model,HttpSession session) {
		try {
			// 로그인한 세션에서 아이디 가져오기 
			String memberId = (String) session.getAttribute("memberId");
			// 아이디가 작성한 게시글을 가져오기 
			List<MyBoardVO> mList = mService.selectBoardList(memberId,currentPage);
			int totalCount = mService.getTotalCount();
			Map<String, Integer>pageInfo = pageUtil.generatePageInfo(totalCount, currentPage,5);
			model.addAttribute("maxPage", pageInfo.get("maxPage"));
			model.addAttribute("startNavi", pageInfo.get("startNavi"));
			model.addAttribute("endNavi", pageInfo.get("endNavi"));
			model.addAttribute("mList", mList);
			return "mypage/myBoard";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "mypage/myBoard";
		}
	}
	@GetMapping("/mypage/myReply")
	public String showMyReply(@RequestParam(value="currentPage", defaultValue="1")		
	int currentPage, Model model,HttpSession session) {
		try {
			// 로그인한 세션에서 아이디 가져오기
			String memberId = (String) session.getAttribute("memberId");
			// 아이디가 작성한 댓글 가져오기 
			List<MyReplyVO> rList = mService.selectReplyList(memberId,currentPage);
			System.out.println("rList size: " + rList.size());
			int totalCount = mService.getTotalCount();
			Map<String, Integer>pageInfo = pageUtil.generatePageInfo(totalCount, currentPage, 5);
			model.addAttribute("maxPage", pageInfo.get("maxPage"));
			model.addAttribute("startNavi", pageInfo.get("startNavi"));
			model.addAttribute("endNavi", pageInfo.get("endNavi"));
			model.addAttribute("rList", rList);
			return "mypage/myReply";
		} catch (Exception e) {
			return "mypage/myReply";
		}
	}




}
