package com.oneyo.spring.myref.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oneyo.spring.common.PageUtill;
import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.myref.controller.dto.CategoryList;
import com.oneyo.spring.myref.controller.dto.MySourceList;
import com.oneyo.spring.myref.service.MyRefService;


@Controller
@RequestMapping("/myRef")
public class MyRefController {
	private MyRefService mService;
	private PageUtill pageUtil;
	
	@Autowired
	public MyRefController(MyRefService mService, PageUtill pageUtil) {
		this.mService = mService;
		this.pageUtil = pageUtil;
	}
	

	@GetMapping("/mypage")
	public String showMypageMain(Model model,
			HttpSession session) {	
		LoginRequest login = null;
		try {
			// 로그인 붙이고 회원 체크 분기처리할때 사용할거임
//			if(session.getAttribute("memberID")!= null) {
//				login = new LoginRequest();
//				login.setMemberId((String)session.getAttribute("memberId"));
//				login.setMemberPw((String)session.getAttribute("memberPw"));
//				System.out.println((String)session.getAttribute("memberId"));
//				System.out.println((String)session.getAttribute("memberPw"));
//		}
//			List<MySourceList> cList = mService.selectCoolSourceList(login);
//			List<MySourceList> iList = mService.selectIceSourceList(login);		
			
			List<MySourceList> cList = mService.selectCoolSourceList();
			List<MySourceList> iList = mService.selectIceSourceList();			
				
			System.out.println(cList);
			System.out.println(iList);
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
	public String showMyIceStorage(Model model, 
			@RequestParam(value="page", defaultValue="1") int currentPage) {
		try {
			int totalCount = mService.getTotalCount();
			
			Map<String, Integer> pageInfo = new PageUtill().generatePageInfo(totalCount, currentPage);
			List<MySourceList> iList = mService.selectIceSourceList(currentPage);
			List<CategoryList> categoryList = mService.getCategoryList();
			System.out.println(iList);
			System.out.println(categoryList);
			if(!iList.isEmpty()) {
				model.addAttribute("maxPage", pageInfo.get("maxPage"));
				model.addAttribute("startNavi", pageInfo.get("startNavi"));
				model.addAttribute("endNavi", pageInfo.get("endNavi"));
				model.addAttribute("iList", iList);
				model.addAttribute("categoryList", categoryList);
				return "mypage/myIceStorage";			
			}else {
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return "mypage/myIceStorage";
	}
	
	
	@GetMapping("/myCoolStorage")
	public String showMyCoolStorage(Model model,
			@RequestParam(value="page", defaultValue="1") int currentPage) {
		try {		
			int totalCount = mService.getTotalCount();
			List<MySourceList> cList = mService.selectCoolSourceList(currentPage);
			System.out.println(cList);
			Map<String, Integer> pageInfo = new PageUtill().generatePageInfo(totalCount, currentPage);			
			
			if(!cList.isEmpty()) {
				model.addAttribute("maxPage", pageInfo.get("maxPage"));
				model.addAttribute("startNavi", pageInfo.get("startNavi"));
				model.addAttribute("endNavi", pageInfo.get("endNavi"));				
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
	
	
	@GetMapping("/delete")
	public String deleteSources(Model model,
			@RequestParam("sourcesNo")int sourcesNo
			) {
//		int result = mService.deleteSources(sourcesNo);
		System.out.println(sourcesNo);
		try {
			return "";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
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
