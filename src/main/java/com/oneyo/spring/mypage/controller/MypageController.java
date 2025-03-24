package com.oneyo.spring.mypage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneyo.spring.mypage.domain.MySourceList;
import com.oneyo.spring.mypage.service.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	private MypageService mService;
	
	@GetMapping("/mypage")
	public String showMypageMain(Model model) {	
		try {
			List<MySourceList> mList = mService.selectSourceList();
			return "mypage/mypage";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "mypage/mypage";
	}
	
	@GetMapping("/myBoard")
	public String showMyBoard() {
		try {
			return "mypage/myBoard";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "mypage/myBoard";
	}
	
	@GetMapping("/myReply")
	public String showMyReply() {
		try {
			return "mypage/myReply";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "mypage/myReply";
	}
	
}
