package com.oneyo.spring.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.oneyo.spring.board.service.BFileService;
import com.oneyo.spring.common.FileUtil;

@Controller
public class BFileController {
	
	@Autowired
	private BFileService fService;
	@Autowired
	private FileUtil fileUtil;
	
	public BFileController(BFileService fService, FileUtil fileUtil) {
		this.fService = fService;
		this.fileUtil = fileUtil;
	}
	
	// 파일첨부
	@PostMapping("/fileUpload")
	public void uploadFile(@RequestParam("uploadFile")MultipartFile uploadFile,
				@RequestParam("boardNo") int boardNo,
				HttpSession session, Model model) throws IllegalStateException, IOException {
		
		if(uploadFile != null && !uploadFile.getOriginalFilename().isBlank()) {
		Map<String, String> fileInfo = fileUtil.saveFile(uploadFile, session, "board");
//		board.setBoardFilename(fileInfo.get("bFilename"));
//		board.setBoardFileRename(fileInfo.get("bFileRename"));
//		board.setBoardFilePath(fileInfo.get("bFilePath"));
		}
	}
	
	


}
