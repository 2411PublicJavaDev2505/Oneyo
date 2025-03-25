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
	public String showSourcesModifyForm(@PathVariable int sourcesNo, Model model) {
		try {
			SourcesVO sources = sService.selectSourcesByNo(sourcesNo);
			model.addAttribute("sources", sources);
			return "sources/update";
		} catch(Exception e) {
			//TODO: handle exception
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "common/error";
		}
	}
	
	@PostMapping("/update")
	public String updateSources(@ModelAttribute SourcesUpdateRequest sources
			, @RequestParam("reloadFile") MultipartFile reloadFile
			, HttpSession session
			, Model model) {
		try {
			if(session.getAttribute("memberId") == null) {
				model.addAttribute("errorMsg", "�α����� �ʿ��մϴ�~!");
				return "common/error";
			}
			String memberId = (String)session.getAttribute("memberId");
			if(!memberId.equals(sources.getSourcesWriter())) {
				model.addAttribute("errorMsg", "�������� �ʴ� �����Դϴ�.");
				return "common/error";
			}
			if(reloadFile != null && !reloadFile.getOriginalFilename().isBlank()) {
				Map<String, String> fileInfo = file.saveFile2(reloadFile, session, "sources");
				sources.setSourcesFilename(fileInfo.get("sFilename"));
				sources.setSourcesFileRename(fileInfo.get("sFilename"));
				sources.setSourcesFilepath(fileInfo.get("sFilename"));
			}
			int result = sService.updateSources(sources);
			return "redirect:/sources/detail/"+sources.getSourcesNo();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "common/error";
		}
	}
	// ���� 
	@GetMapping("/delete")
	public String deleteSources(@PathVariable int sourcesNo
			, Model model) {
		try {
			int result = sService.deleteSources(sourcesNo);
			return "redirect:/recipe/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "common/error";
		}
	}
}
	
