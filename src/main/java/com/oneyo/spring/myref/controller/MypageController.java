package com.oneyo.spring.myref.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oneyo.spring.myref.controller.dto.MySourceList;
import com.oneyo.spring.myref.service.MypageService;


@Controller
@RequestMapping("/mypage")
public class MypageController {
	private MypageService mService;
	
	@Autowired
	public MypageController(MypageService mService) {
		this.mService = mService;
	}
	

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
	
	
	@GetMapping("/myRefridge")
	public String showMyRefridge() {
		try {
			return "mypage/myRefridge";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "mypage/myRefridge";
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
