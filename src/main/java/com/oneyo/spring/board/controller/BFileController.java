package com.oneyo.spring.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
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
	

	


}
