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

import com.oneyo.spring.board.domain.BoardVO;
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
			System.out.println(memberId);
			// 아이디가 작성한 게시글을 가져오기 
			List<MyBoardVO> mList = mService.selectBoardList(memberId,currentPage);
			System.out.println(mList);
			int totalCount = mService.getTotalBoardCount(memberId);
			System.out.println(totalCount);
			Map<String, Integer>pageInfo = pageUtil.generatePageInfo(totalCount, currentPage,7);
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
	@GetMapping("/mypage/myBoardSearch")
	public String showSearchMBoardList(
			@RequestParam("searchCondition") String searchCondition,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage
			, Model model) {
		try {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("searchCondition", searchCondition);
			paramMap.put("searchKeyword", searchKeyword);
			List<BoardVO> searchBList = mService.selectOneByKeyword(paramMap, currentPage); //일반게시판
			int searchCount = mService.getTotalCount(paramMap);
			Map<String, Integer>pageInfo = pageUtil.generatePageInfo(searchCount, currentPage);
			model.addAttribute("maxPage", pageInfo.get("maxPage"));
			model.addAttribute("startNavi", pageInfo.get("startNavi"));
			model.addAttribute("endNavi", pageInfo.get("endNavi"));
			model.addAttribute("searchBList", searchBList);
			return "mypage/myBoardSearch";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
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
			int totalCount = mService.getTotalCount(memberId);	
			Map<String, Integer>pageInfo = pageUtil.generatePageInfo(totalCount, currentPage, 7);
			model.addAttribute("maxPage", pageInfo.get("maxPage"));
			model.addAttribute("startNavi", pageInfo.get("startNavi"));
			model.addAttribute("endNavi", pageInfo.get("endNavi"));
			model.addAttribute("rList", rList);
			return "mypage/myReply";
		} catch (Exception e) {
			return "mypage/myReply";
		}
	}
	
	@GetMapping("/mypage/deletemyReply")
    public String deleteReply(@RequestParam("replyNo") int replyNo, @RequestParam("boardNo") int boardNo) {
        int result = mService.deleteReply(replyNo);
        
        if (result > 0) {
            return "redirect:/board/detail?boardNo=" + boardNo;  // 게시글 상세 페이지로 이동
        } else {
            return "common/error";  // 삭제 실패 시 에러 페이지로 이동
        }
    }




}
