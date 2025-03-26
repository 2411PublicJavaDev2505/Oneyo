package com.oneyo.spring.sources.controller;

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
import com.oneyo.spring.common.FileUtil;
import com.oneyo.spring.common.PageUtill;
import com.oneyo.spring.sources.controller.dto.SourcesInsertRequest;
import com.oneyo.spring.sources.controller.dto.SourcesUpdateRequest;
import com.oneyo.spring.sources.domin.SourcesVO;
import com.oneyo.spring.sources.service.SourcesService;

@Controller
@RequestMapping("/sources")
public class SourcesController {
	
	private SourcesService sService;
	private FileUtil file;
	private PageUtill page;
	
	@Autowired
	public SourcesController(SourcesService sService, PageUtill page, FileUtil file) {
		this.sService = sService;
		this.file = file;
		this.page = page;
	}
	
	@GetMapping("/insert")
	public String InsertSources() {
		return "sources/insert";
	}
	
	@PostMapping("/insert")
	public String insertSources(@ModelAttribute SourcesInsertRequest sources
			, @RequestParam("uploadFile") MultipartFile uploadFile
			, HttpSession session
			, Model model) {
		try {
			if(session.getAttribute("memberId") != null) {
				sources.setSourcesWriter((String)session.getAttribute("memberId"));
			}else {
				model.addAttribute("errorMsg", "�α����� �ʿ��մϴ�~!" );
				return "common/error";
			}
			
			if(uploadFile != null && !uploadFile.getOriginalFilename().isBlank()) {
				Map<String, String> fileInfo = file.saveFile2(uploadFile, session, "sources");
				sources.setSourcesFilename(fileInfo.get("sFilename"));
				sources.setSourcesFileRename(fileInfo.get("sFileRename"));
				sources.setSourcesFilepath(fileInfo.get("sFilepath"));
			}
			int result = sService.insertSources(sources);
			return "redirect:/sources/SourcesList";
		} catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "common/error";
		}
	}
	
	
	@GetMapping("/update/{sourcesNo}")
	public String showSourcesModifyForm(HttpSession session, Model model
			,@RequestParam("sourcesNo")int sourcesNo) {
		try {
			String memberId = (String)session.getAttribute("memberId");
			if(memberId == null) {
				model.addAttribute("errorMsg","로그인이 필요합니다~!");
				return "common/error";
			}
			SourcesVO sources = sService.selectSourcesByNo(sourcesNo);
			model.addAttribute("sources",sources);
			String memberNickname = sService.getMemberNickname(memberId);
			session.setAttribute("memberNickname", memberNickname);
			
			return "/sources/sourcesUpdate";			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}

	}
	
	@PostMapping("/update")
	public String  updateSources(Model model, SourcesInsertRequest sources, HttpSession session
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
				Map<String, String> fileInfo = file.saveFile(reloadFile, session, "sources");
				sources.setSourcesFilename(fileInfo.get("sFilename"));
				sources.setSourcesFileRename(fileInfo.get("sFileRename"));
				sources.setSourcesFilepath(fileInfo.get("sFilepath"));
			}			
			
			int result = sService.updateSources(sources);
			if(result > 0) {
				model.addAttribute("sources", sources.getSourcesWriter());
				model.addAttribute("sourcesNo", sources.getSourcesNo());
				return "redirect:/sources/detail/{sourcesNo}";
			}else {
				model.addAttribute("errorMsg","데이터 수정에 실패하였습니다.");
				return "common/error";
			}
		}catch (IllegalArgumentException  e) {
	        model.addAttribute("errorMsg", e.getMessage());
	        return "sources/sourcesUpdate";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	// ���� 
	public String deleteNotice(
			@RequestParam("sourcesNo") int sourcesNo, Model model) {
		try {
			int result = sService.deleteSources(sourcesNo);
			return "redirect:/sources/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
}
	
