package com.oneyo.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.domain.BoardVO;
import com.oneyo.spring.board.domain.ReplyVO;
import com.oneyo.spring.board.service.BFileService;
import com.oneyo.spring.board.service.BoardService;
import com.oneyo.spring.board.service.ReplyService;
import com.oneyo.spring.common.FileUtil;
import com.oneyo.spring.common.PageUtill;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService bService;
	@Autowired
	private ReplyService rService;
	@Autowired
	private PageUtill pageUtil;
	@Autowired
	private FileUtil fileUtil;
	
	public BoardController(BoardService bService, ReplyService rService, 
			PageUtill pageUtil, FileUtil fileUtil) {
		this.bService = bService;
		this.rService = rService;
		this.pageUtil = pageUtil;
		this.fileUtil = fileUtil;
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
			@RequestParam("uploadFile")MultipartFile uploadFile,
			HttpSession session, Model model) {
		try {
			String memberId = (String)session.getAttribute("memberId");
			if(memberId == null) {
				model.addAttribute("errorMsg","로그인이 필요합니다~");
				return "common/error";
			}
			if(uploadFile != null && !uploadFile.getOriginalFilename().isBlank()) {
				Map<String, String> fileInfo = fileUtil.saveFile(uploadFile, session, "board");
				board.setMemberId(memberId);
				board.setBoardFilename(fileInfo.get("bFilename"));
				board.setBoardFileRename(fileInfo.get("bFileRename"));
				board.setBoardFilepath(fileInfo.get("bFilepath"));
			}
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
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}

	}
	@PostMapping("/update")
	public String  updateBoard(Model model, BoardAddRequest board, HttpSession session
				,@RequestParam("reloadFile")MultipartFile reloadFile) {
		try {
			if(session.getAttribute("memberId") == null) {
				model.addAttribute("errorMsg","로그인이 필요합니다.");
				return "common/error";
			}
//			String memberId = (String)session.getAttribute("memberId");
//			if(!memberId.equals(board.getMemberId())) {
//				model.addAttribute("errorMsg","자신이 작성한 글만 수정할 수 있습니다.");
//				return "common/error";
//			}
			// 업로드된 파일 있는지 체크
			if(reloadFile != null && !reloadFile.getOriginalFilename().isBlank()) {
				Map<String, String> fileInfo = fileUtil.saveFile(reloadFile, session, "board");
				board.setBoardFilename(fileInfo.get("bFilename"));
				board.setBoardFileRename(fileInfo.get("bFileRename"));
				board.setBoardFilepath(fileInfo.get("bFilepath"));
			}			
			
			int result = bService.updateBoard(board);
			if(result > 0) {
				model.addAttribute("board", board.getMemberId());
				model.addAttribute("boardNo", board.getBoardNo());
				return "redirect:/board/detail/{boardNo}";
			}else {
				model.addAttribute("errorMsg","데이터 수정에 실패하였습니다.");
				return "common/error";
			}
		}catch (IllegalArgumentException  e) {
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
	public String showBoardDetail(@PathVariable("boardNo") int boardNo, Model model
				, HttpSession session) {
		try {
			if(session.getAttribute("memberId") == null) {
				model.addAttribute("errorMsg","로그인이 필요합니다.");
				return "common/error";
			}
			
			BoardVO board = bService.selectOneBoard(boardNo);		
			List<ReplyVO> reply = rService.getReplyByBoardNo(boardNo); // 댓글 조회
			Integer count = bService.boardCountUpdate(boardNo); // 조회수 카운트
			model.addAttribute("board", board);
			model.addAttribute("reply", reply);
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
//			List<BoardVO> searchNList = bService.NoticeOneByKeyword(paramMap); // 공지사항
			List<BoardVO> searchBList = bService.selectOneByKeyword(paramMap, currentPage); //일반게시판
			int searchCount = bService.getTotalCount(paramMap);
			Map<String, Integer>pageInfo = pageUtil.generatePageInfo(searchCount, currentPage);
			model.addAttribute("maxPage", pageInfo.get("maxPage"));
			model.addAttribute("startNavi", pageInfo.get("startNavi"));
			model.addAttribute("endNavi", pageInfo.get("endNavi"));
//			model.addAttribute("searchList", searchNList);
			model.addAttribute("searchBList", searchBList);
			return "board/boardSearch";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
}
