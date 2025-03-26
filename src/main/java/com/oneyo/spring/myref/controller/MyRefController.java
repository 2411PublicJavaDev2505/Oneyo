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
import com.oneyo.spring.member.domain.MemberVO;
import com.oneyo.spring.member.service.MemberService;
import com.oneyo.spring.mypage.service.MypageService;
import com.oneyo.spring.myref.controller.dto.CategoryList;
import com.oneyo.spring.myref.controller.dto.CheckLoginRequest;
import com.oneyo.spring.myref.controller.dto.DeleteSource;
import com.oneyo.spring.myref.controller.dto.MySourceList;
import com.oneyo.spring.myref.controller.dto.SearchSourceRequest;
import com.oneyo.spring.myref.controller.dto.SourceAddRequest;
import com.oneyo.spring.myref.service.MyRefService;


@Controller
@RequestMapping("/mypage")
public class MyRefController {
	private MyRefService mService;
	private MemberService mBService;
	private PageUtill pageUtil;
	
	@Autowired
	public MyRefController(MyRefService mService, PageUtill pageUtil) {
		this.mService = mService;
		this.pageUtil = pageUtil;
	}

	// 마이페이지 전체 출력
	@GetMapping("/mypage")
	public String showMypageMain(Model model,
			@RequestParam(value="page", defaultValue="1") int currentPage,
			HttpSession session) {	
		try {
			// 로그인 붙이고 회원 체크 분기처리할때 사용할거임
			CheckLoginRequest login = null;
			System.out.println("이름은?"+session.getAttribute("memberId"));
			if(session.getAttribute("memberId")!= null) {
				login = new CheckLoginRequest();
				login.setMemberId((String)session.getAttribute("memberId"));
//				login.setMemberPw((String)session.getAttribute("memberPw"));
//				String memberId = login.getMemberId();
//				String memberPw = login.getMemberPw();
//				System.out.println((String)session.getAttribute("memberId"));
				System.out.println(login);
		}
			
			List<MySourceList> cList = mService.selectCoolSourceList(currentPage, login);
			List<MySourceList> iList = mService.selectIceSourceList(currentPage, login);
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
	
	
	// 냉동고 재료 리스트 출력
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




	// 냉장고 재료 리스트
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


	// 재료 검색 리스트
	@PostMapping("/search")
	public String searchSource(Model model,
			HttpSession session,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value="page", defaultValue="1") int currentPage) {	
			String memberId = (String)session.getAttribute("memberId");
			if(memberId != null) {
			SearchSourceRequest searchList = new SearchSourceRequest(memberId, searchKeyword);
			int searchCount = mService.getSearchCount(searchList);
			System.out.println(searchCount);
			Map<String, Integer> pageInfo = new PageUtill().generatePageInfo(searchCount, currentPage, 5);
			
			List<MySourceList>sList = mService.searchSourceList(currentPage, searchList);
			System.out.println(sList);
			if(sList != null) {
					model.addAttribute("maxPage", pageInfo.get("maxPage"));
					model.addAttribute("startNavi", pageInfo.get("startNavi"));
					model.addAttribute("endNavi", pageInfo.get("endNavi"));
					model.addAttribute("sList", sList);		
					model.addAttribute("searchKeyword", searchKeyword);		
					return "mypage/search";
				}return "common/error";
			} return "common/error";
	}
	
	
	// 냉장고 재료 추가
	@PostMapping("/myCoolStorage")
	public String insertMyCoolStorage(Model model, 
			@RequestParam(value="page", defaultValue="1") int currentPage,
			@RequestParam("firstCategory") String firstCategory,
			@RequestParam("secondCategory") String secondCategory,
			@RequestParam("thirdCategory") String thirdCategory,
			@RequestParam("sourceName") String sourceName,
			@RequestParam("sourceCount") String sourceCount,
			@RequestParam("dueDate") Date dueDate,
			HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		String storageDate = "SYSDATE";
		String storageCode = "C";		
		
		SourceAddRequest addSource = new SourceAddRequest(memberId, firstCategory, secondCategory, thirdCategory, sourceCount, sourceName, dueDate, storageDate, storageCode);
		int duplication = mService.findDuplicated(addSource);
		System.out.println(duplication);
		
		if(addSource != null) {
			int result = mService.addSource(addSource);
			if(result > 0) {
				return "redirect:/mypage/myCoolStorage";
			} return "common/error";
		}	return "mypage/myCoolStorage";
	}	
	

	// 냉동고 재료 추가
	@PostMapping("/myIceStorage")
	public String insertMyIceStorage(Model model, 
			@RequestParam(value="page", defaultValue="1") int currentPage,
			@RequestParam("firstCategory") String firstCategory,
			@RequestParam("secondCategory") String secondCategory,
			@RequestParam("thirdCategory") String thirdCategory,
			@RequestParam("sourceName") String sourceName,
			@RequestParam("sourceCount") String sourceCount,
			@RequestParam("dueDate") Date dueDate,
			HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		String storageDate = "SYSDATE";
		String storageCode = "I";		
//		System.out.println(dueDate);
		SourceAddRequest addSource = new SourceAddRequest(memberId, firstCategory, secondCategory, thirdCategory, sourceCount, sourceName, dueDate, storageDate, storageCode);
		if(addSource != null) {
			int result = mService.addSource(addSource);
			if(result > 0) {
				return "redirect:/mypage/myIceStorage";
			} return "common/error";
		}	return "mypage/myIceStorage";
	}
	
	
	
	// 재료삭제 (냉장, 냉동 통합)
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
						return "redirect:/mypage/mypage";
					}
				}else if(storageCode.equals("C")) {
					DeleteSource dCoolSource = new DeleteSource(memberId, sourcesNo, dueDate, storageCode);					
					System.out.println("mamberID =" + memberId);
					System.out.println("sourcesNo =" + sourcesNo);
					System.out.println("dueDate =" + dueDate);
					System.out.println("storageCode =" + storageCode);
					result = mService.deleteCoolSource(dCoolSource);		
					if(result > 0) {
						if(storageCode.equals("I")) {
							return "redirect:/mypage/myIceStorage";							
						}else {
							return "redirect:/mypage/myCoolStorage";		
						}
					}
				}
			}	
			return "redirect:/mypage/mypage";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "common/error";
	}
	
	//재료 수정
	@PostMapping("/updateSource")
	public String updateSource(@RequestParam("sourcesNo") int sourcesNo,
	                           @RequestParam("sourceCount") int sourceCount,
	                           @RequestParam("dueDate") String dueDate) {
	    // 서비스 호출하여 DB 업데이트
	    //sourceService.updateSource(sourcesNo, sourceCount, dueDate);
		
	    return "redirect:/mypage";
	}
	
	
}
