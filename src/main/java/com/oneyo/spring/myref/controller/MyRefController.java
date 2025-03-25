package com.oneyo.spring.myref.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oneyo.spring.common.PageUtill;
import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.myref.controller.dto.CategoryList;
import com.oneyo.spring.myref.controller.dto.CheckLoginRequest;
import com.oneyo.spring.myref.controller.dto.DeleteSource;
import com.oneyo.spring.myref.controller.dto.MySourceList;
import com.oneyo.spring.myref.service.MyRefService;


@Controller
@RequestMapping("/mypage")
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
			@RequestParam(value="page", defaultValue="1") int currentPage,
			HttpSession session) {	
		try {
			
			// 로그인 붙이고 회원 체크 분기처리할때 사용할거임
			CheckLoginRequest login = null;
			if(session.getAttribute("memberId")!= null) {
				login = new CheckLoginRequest();
				login.setMemberId((String)session.getAttribute("memberId"));
				login.setMemberPw((String)session.getAttribute("memberPw"));
//				System.out.println((String)session.getAttribute("memberId"));
		}
			List<MySourceList> cList = mService.selectCoolSourceList(currentPage, login);
			List<MySourceList> iList = mService.selectIceSourceList(currentPage, login);		
							
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
	public String showMyIceStorage(Model model, 
			@RequestParam(value="page", defaultValue="1") int currentPage,
			HttpSession session) {
		try {
			CheckLoginRequest login = null;
			
			if(session.getAttribute("memberId")!= null) {
				login = new CheckLoginRequest();
				login.setMemberId((String)session.getAttribute("memberId"));
				login.setMemberPw((String)session.getAttribute("memberPw"));
				login.setStorageCode("I");
			}
			int totalCount = mService.getTotalCount(login);
//			System.out.println(totalCount);
			Map<String, Integer> pageInfo = new PageUtill().generatePageInfo(totalCount, currentPage, 5);
			List<MySourceList> iList = mService.selectIceSourceList(currentPage, login);
//			System.out.println(iList);
			List<CategoryList> categoryList = mService.getCategoryList();
//			System.out.println(iList);
//			System.out.println(categoryList);
			
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
	
	@PostMapping("/myIceStorage")
	public String insertMyIceStorage(Model model, 
			@RequestParam(value="page", defaultValue="1") int currentPage,
			@RequestParam("firstCategory") String firstCategory,
			@RequestParam("secondCategory") String secondCategory,
			@RequestParam("thirdCategory") String thirdCategory,			
			HttpSession session) {
		
//		System.out.println(firstCategory);
//		System.out.println(secondCategory);
		System.out.println(thirdCategory);
		return "mypage/myIceStorage";
	}
	
	
	
	@GetMapping("/myCoolStorage")
	public String showMyCoolStorage(Model model,
			@RequestParam(value="page", defaultValue="1") int currentPage,
			HttpSession session) {
		try {

			CheckLoginRequest login = null;
			
			if(session.getAttribute("memberId")!= null) {
				login = new CheckLoginRequest();
				login.setMemberId((String)session.getAttribute("memberId"));
				login.setMemberPw((String)session.getAttribute("memberPw"));			
				login.setStorageCode("C");
			}

			int totalCount = mService.getTotalCount(login);
			Map<String, Integer> pageInfo = new PageUtill().generatePageInfo(totalCount, currentPage, 5);
			List<MySourceList> cList = mService.selectCoolSourceList(currentPage, login);
//			System.out.println(cList);
			List<CategoryList> categoryList = mService.getCategoryList();
//			System.out.println(cList);
//			System.out.println(categoryList);
			if(!cList.isEmpty()) {
				model.addAttribute("maxPage", pageInfo.get("maxPage"));
				model.addAttribute("startNavi", pageInfo.get("startNavi"));
				model.addAttribute("endNavi", pageInfo.get("endNavi"));
				model.addAttribute("cList", cList);
				model.addAttribute("categoryList", categoryList);
				return "mypage/myCoolStorage";			
			}else {
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return "mypage/myCoolStorage";
	}
	
	
	@GetMapping("/delete")
	public String deleteSources(Model model,
			HttpSession session,
			@RequestParam("sourcesNo")int sourcesNo,
			@RequestParam("dueDate") Date dueDate,
			@RequestParam("storageCode") String storageCode
			) {
		try {
//			System.out.println(sourcesNo);
//			System.out.println(dueDate);
			CheckLoginRequest login = null;
			int result = 0;
			if(session.getAttribute("memberId")!= null) {
				login = new CheckLoginRequest();
				login.setMemberId((String)session.getAttribute("memberId"));
				String memberId = (String)session.getAttribute("memberId");
				if(storageCode.equals("I")) {
					DeleteSource dIceSource = new DeleteSource(memberId, sourcesNo, dueDate, storageCode);	
					System.out.println("mamberID =" + memberId);
					System.out.println("sourcesNo =" + sourcesNo);
					System.out.println("dueDate =" + dueDate);
					System.out.println("storageCode =" + storageCode);
					result = mService.deleteIceSource(dIceSource);
					if(result > 0) {
						return "/mypage/mypage";
					}
				}else if(storageCode.equals("C")){
					DeleteSource dCoolSource = new DeleteSource(memberId, sourcesNo, dueDate, storageCode);					
					System.out.println("mamberID =" + memberId);
					System.out.println("sourcesNo =" + sourcesNo);
					System.out.println("dueDate =" + dueDate);
					System.out.println("storageCode =" + storageCode);
					result = mService.deleteIceSource(dCoolSource);		
					if(result > 0) {
						return "/mypage/mypage";
					}
				}
			}	
			return "mypage/mypage";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "mypage/mypage";
	}
	

}
