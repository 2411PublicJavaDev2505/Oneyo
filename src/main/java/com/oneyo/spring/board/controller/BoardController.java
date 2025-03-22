package com.oneyo.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.controller.dto.BoardUpdateRequest;
import com.oneyo.spring.board.domain.BoardVO;
import com.oneyo.spring.board.service.BoardService;
import com.oneyo.spring.common.PageUtill;

@Controller
@RequestMapping("/board")
public class BoardController {

	private BoardService bService;
	private PageUtill pageUtil;
	
	public BoardController(BoardService bService, PageUtill pageUtil) {
		this.bService = bService;
		this.pageUtil = pageUtil;
	}
	// 게시판 등록
	@GetMapping("/insert")
	public String showBoardInsertForm(HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("memberId");
		if(memberId == null) {
			model.addAttribute("errorMsg","로그인이 필요합니다~!");
			return "common/error";
		}
		String memberNickname = bService.getMemberNickname(memberId);
		session.setAttribute("memberNickname", memberNickname);
		
		return "/board/boardInsert";
	}
	@PostMapping("/insert")
	public String insertBoard(@ModelAttribute BoardAddRequest board,
			HttpSession session, Model model) {
		try {
			String memberId = (String)session.getAttribute("memberId");
			
			if(session.getAttribute("memberId")==null) {
				model.addAttribute("errorMsg","로그인이 필요합니다~");
				return "common/error";
			}
			board.setMemberId(memberId);
			int result = bService.insertBoard(board);
			return "redirect:/board/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
	// 게시판 수정
	@GetMapping("/update")
	public String showBoardUpdateForm(HttpSession session, Model model
			,@RequestParam("boardNo")int boardNo) {
		String memberId = (String)session.getAttribute("memberId");
		if(memberId == null) {
			model.addAttribute("errorMsg","로그인이 필요합니다~!");
			return "common/error";
		}
		BoardVO board = bService.selectOneBoard(boardNo);
		model.addAttribute("board",board);
		String memberNickname = bService.getMemberNickname(memberId);
		session.setAttribute("memberNickname", memberNickname);
		
		return "/board/boardUpdate";
	}
	@PostMapping("/update")
	public String  updateBoard(Model model, BoardUpdateRequest board) {
		try {
			int result = bService.updateBoard(board);
			if(result > 0) {
				model.addAttribute("board", board.getMemberId());
				model.addAttribute("boardNo", board.getBoardNo());
				return "redirect:/board/detail/{boardNo}";
			}else {
				model.addAttribute("errorMessage","데이터 수정에 실패하였습니다.");
				return "common/error";
			}
		}catch (IllegalArgumentException  e) {
			// TODO: handle exception
	        model.addAttribute("errorMsg", e.getMessage());
	        return "board/boardUpdate";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
	
	// 게시판 삭제
	@GetMapping("/delete")
	public String deleteNotice(
			@RequestParam("boardNo") int boardNo, Model model) {
		try {
			int result = bService.deleteBoard(boardNo);
			return "redirect:/board/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
	
	// 게시판 전체목록
	@GetMapping("/list")
	public String showBoardList(@RequestParam(value="currentPage", defaultValue="1")		
			int currentPage, Model model) {
		try {
			List<BoardVO> nList = bService.printNoticeList();
			List<BoardVO> bList = bService.printAllBoardList(currentPage);
			int totlaCount = bService.getTotalCount();
			Map<String, Integer>pageInfo = pageUtil.generatePageInfo(totlaCount, currentPage);
			model.addAttribute("maxPage", pageInfo.get("maxPage"));
			model.addAttribute("startNavi", pageInfo.get("startNavi"));
			model.addAttribute("endNavi", pageInfo.get("endNavi"));
			model.addAttribute("nList", nList);
			model.addAttribute("bList", bList);
			return "/board/boardList";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
	// 게시판 상세 조회
	@GetMapping("/detail/{boardNo}")
	public String showBoardDetail(@PathVariable("boardNo") int boardNo, Model model) {
		try {
			BoardVO board = bService.selectOneBoard(boardNo);
			model.addAttribute("board", board);
			return "/board/boardDeteail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
	// 게시판 검색
	@GetMapping("/search")
	public String showSearchList(
			@RequestParam("searchCondition") String searchCondition,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage
			, Model model) {
		try {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("searchCondition", searchCondition);
			paramMap.put("searchKeyword", searchKeyword);
			List<BoardVO> searchNList = bService.NoticeOneByKeyword(paramMap);
			List<BoardVO> searchBList = bService.selectOneByKeyword(paramMap, currentPage);
			int searchCount = bService.getTotalCount(paramMap);
			Map<String, Integer>pageInfo = pageUtil.generatePageInfo(searchCount, currentPage);
			model.addAttribute("maxPage", pageInfo.get("maxPage"));
			model.addAttribute("startNavi", pageInfo.get("startNavi"));
			model.addAttribute("endNavi", pageInfo.get("endNavi"));
			model.addAttribute("searchList", searchNList);
			model.addAttribute("searchBList", searchBList);
			return "/board/boardList";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
}
