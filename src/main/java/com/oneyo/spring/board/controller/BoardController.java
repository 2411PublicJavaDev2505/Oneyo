package com.oneyo.spring.board.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
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
import com.oneyo.spring.board.controller.dto.BoardUpdateRequest;
import com.oneyo.spring.board.domain.BoardFileVO;
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
	private BFileService fService;
	@Autowired
	private PageUtill pageUtil;
	@Autowired
	private FileUtil fileUtil;
	
	public BoardController(BoardService bService, ReplyService rService, BFileService fService,
			PageUtill pageUtil, FileUtil fileUtil) {
		this.bService = bService;
		this.rService = rService;
		this.fService = fService;
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
			@RequestParam("multiFile")List<MultipartFile> multiFile,
			HttpServletRequest request,
			HttpSession session, Model model) {
		try {
			String memberId = (String)session.getAttribute("memberId");
			if(memberId ==null) {
				model.addAttribute("errorMsg","로그인이 필요합니다~");
				return "common/error";
			}
			board.setMemberId(memberId);
			int result = bService.insertBoard(board);
			
			// 파일첨부
			if(multiFile != null && !multiFile.isEmpty()) {
				for(MultipartFile file : multiFile) {
					if(!file.getOriginalFilename().isBlank()) {
						Map<String, String> fileInfo = fileUtil.saveFile(file, session, "board");
						System.out.println("파일 저장 결과: " + fileInfo);
						
						BoardFileVO boardFile = new BoardFileVO();
						boardFile.setBoardNo(board.getBoardNo());
						boardFile.setbFileName(board.getBoardFilename());
						boardFile.setbFileRename(board.getBoardFileRename());
						boardFile.setbFilePath(board.getBoardFilePath());
						
						int fResult = fService.insertBoardFile(boardFile);
					}
				}
			}
			
//			// util없이 작성해보기
//			//받아온 것 출력 확인
//			System.out.println("multiFile:"+multiFile);
//			//path 가져오기
//			String path = request.getSession().getServletContext().getRealPath("resources");
//			String root = path +"\\"+"bUploadFiles";
//			
//			File fileCheck = new File(root);
//			
//			if(!fileCheck.exists()) fileCheck.mkdirs();
//			
//			List<Map<String, String>> fileList = new ArrayList<>();
//			
//			for(int i = 0; i < multiFile.size(); i++) {
//				String originFile = multiFile.get(i).getOriginalFilename();
//				String ext = originFile.substring(originFile.lastIndexOf("."));
//				String changeFile = UUID.randomUUID().toString() + ext;
//				
//				Map<String, String> map = new HashMap<>();
//				map.put("originFile", originFile);
//				map.put("changeFile", changeFile);
//				
//				fileList.add(map);
//			}
//			//파일업로드
//			try {
//				for(int i = 0; i<multiFile.size(); i++) {
//					File uploadFile = new File(root +"\\"+ fileList.get(i).get("changeFile"));
//					multiFile.get(i).transferTo(uploadFile);
//				}
//				System.out.println("다중 파일 업로드 성공!");
//			} catch (Exception e) {
//				System.out.println("다중 파일 업로드 실패");
//				// 만약 업로드 실패하면 파일 삭제
//				for(int i = 0; i <multiFile.size(); i++) {
//					new File(root + "\\"+ fileList.get(i).get("changeFile")).delete();
//				}
//				e.printStackTrace();
//			} 
						
			return "redirect:/board/detail/" + board.getBoardNo();
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
	@PostMapping("/update/{boardNo}")
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
			List<ReplyVO> reply = rService.getReplyByBoardNo(boardNo); // 댓글 조회
//			BoardFileVO bFile = fService.selectBoardFileOneByNo(boardNo);// 첨부파일 조회
			model.addAttribute("board", board);
			model.addAttribute("reply", reply);
//			model.addAttribute("bFile", bFile);
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
