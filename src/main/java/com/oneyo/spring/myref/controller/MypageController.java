package com.oneyo.spring.myref.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
			List<MySourceList> cList = mService.selectCoolSourceList();
			List<MySourceList> iList = mService.selectIceSourceList();
			
//			System.out.println(cList);
//			System.out.println(iList);
			if(!cList.isEmpty() && !iList.isEmpty()) {
				model.addAttribute("cList", cList);
				model.addAttribute("iList", iList);
				return "mypage/mypage";			
			}else {
				return "common/error";
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "mypage/mypage";
	}
	
	
	@GetMapping("/myIceStorage")
	public String showMyIceStorage(Model model) {
		try {
//			이건 하나의 쿼리문으로 시도해본거 
//			Map<String, String> paramMap = new HashMap<String, String>();
//			paramMap.put("selectStorage", selectStorage);
//			System.out.println(selectStorage);
//			System.out.println(paramMap);
//			List<MySourceList> storageList = mService.selectStorageList(paramMap);
//			System.out.println(storageList);
//			model.addAttribute("storageList",storageList);
			
			List<MySourceList> cList = mService.selectCoolSourceList();
			List<MySourceList> iList = mService.selectIceSourceList();
			
//			System.out.println(cList);
//			System.out.println(iList);
			
			if(!cList.isEmpty() && !iList.isEmpty()) {
				model.addAttribute("cList", cList);
				model.addAttribute("iList", iList);
				return "mypage/myIceStorage";			
			}else {
				return "common/error";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "mypage/myCoolStorage";
	}
	
	
	@GetMapping("/myCoolStorage")
	public String showMyCoolStorage(Model model) {
		try {		
			List<MySourceList> cList = mService.selectCoolSourceList();
			if(!cList.isEmpty()) {
				model.addAttribute("cList", cList);
				return "mypage/myCoolStorage";			
			}else {
				return "common/error";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "mypage/myCoolStorage";
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
