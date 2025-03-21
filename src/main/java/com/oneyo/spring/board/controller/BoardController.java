package com.oneyo.spring.board.controller;

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
	public String showBoardInsertForm() {
		return "/board/boardInsert";
	}
	@PostMapping("/insert")
	public String insertBoard(@ModelAttribute BoardAddRequest board,
			HttpSession session, Model model) {
		try {
			if(session.getAttribute("memberId")!=null) {
				board.setMemberId((String)session.getAttribute("memberId"));
			}else {
				model.addAttribute("errorMsg","로그인이 필요합니다~!");
				return "common/error";
			}
			int result = bService.insertBoard(board);
			return "redirect:/board/boardList";
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
	}
	
	// 게시판 전체목록
	@GetMapping("/list")
	public String showBoardList(@RequestParam(value="page", defaultValue="1")
			int currentPage, Model model) {
		try {
			List<BoardVO> bList = bService.printAllBoardList(currentPage);
			int totlaCount = bService.getTotalCount();
			Map<String, Integer>pageInfo = pageUtil.generatePageInfo(totlaCount, currentPage);
			model.addAttribute("maxPage", pageInfo.get("maxPage"));
			model.addAttribute("startNavi", pageInfo.get("startNavi"));
			model.addAttribute("endNavi", pageInfo.get("endNavi"));
			model.addAttribute("bList", bList);
			return "/board/boardList";
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
	}
	
	// 게시판 상세 조회
	@GetMapping("/detail/{boardNo}")
	public String showBoardDetail(@PathVariable("boardNo") int boardNo, Model model) {
		try {
			BoardVO board = bService.selectOneBoard(boardNo);
			model.addAttribute("board", board);
			return "/board/boardDetail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
}
