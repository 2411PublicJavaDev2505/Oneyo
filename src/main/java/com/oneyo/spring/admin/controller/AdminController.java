package com.oneyo.spring.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oneyo.spring.admin.controller.dto.MemberListRequest;
import com.oneyo.spring.admin.service.AdminService;
import com.oneyo.spring.board.domain.BoardVO;
import com.oneyo.spring.common.PageUtill;
import com.oneyo.spring.member.domain.MemberVO;
import com.oneyo.spring.member.service.MemberService;
import com.oneyo.spring.myref.controller.dto.CategoryList;
import com.oneyo.spring.myref.service.MyRefService;

@Controller // 관리자페이지
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService aService;
	@Autowired
	private PageUtill pageUtil;
	private MyRefService mService;

	
	@Autowired
	public AdminController(AdminService aService, MyRefService mService) {
		this.aService = aService;
		this.mService = mService;

	}
	
	// 관리자 회원관리(회원 삭제)	
	@GetMapping("/member/delete")
	public String deleteMember(@RequestParam("memberId") String memberId, Model model) {
		try {
			int result = aService.deleteMember(memberId);
			if(result>0) {
				return "redirect:/admin/member";
			}else {
				model.addAttribute("errorMsg","회원 삭제 실패");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}

	// 관리자 회원관리(회원 목록 조회)
	@GetMapping("/member")
	public String printAllMember(@RequestParam(value="page", defaultValue="1") int currentPage,
			HttpSession session  , Model model) {
		try {
			List<MemberVO> mList = aService.selectAllMember(currentPage);
			int totalCount = aService.selectListCount();
			Map<String, Integer> pageInfo = pageUtil.generatePageInfo(totalCount, currentPage);
			if(!mList.isEmpty()) {
				model.addAttribute("maxPage", pageInfo.get("maxPage"));
				model.addAttribute("startNavi", pageInfo.get("startNavi"));
				model.addAttribute("endNavi", pageInfo.get("endNavi"));
				model.addAttribute("mList", mList);

				return "admin/adminMember";
			}else {
				model.addAttribute("errorMsg","데이터가 존재하지 않습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
	// 관리자 회원 검색
	@GetMapping("/member/search")
	public String showSearchList(
			 @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchKeyword") String searchKeyword
			, @RequestParam(value="currentPage", defaultValue="1" )int currentPage
			, Model model) {
		try {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("searchCondition", searchCondition);
			paramMap.put("searchKeyword", searchKeyword);
			List<MemberListRequest>  searchList = aService.selectOneByKeyword(paramMap, currentPage);
			int searchCount = aService.getSearchCount(paramMap);
			Map<String, Integer>pageInfo = pageUtil.generatePageInfo(searchCount, currentPage);
			model.addAttribute("maxPage", pageInfo.get("maxPage"));
			model.addAttribute("startNavi", pageInfo.get("startNavi"));
			model.addAttribute("endNavi", pageInfo.get("endNavi"));
			model.addAttribute("searchList", searchList);
			return "admin/memSearch";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
	
	// 카테고리 등록
	@GetMapping("/category/insert")
	public String showCategoryForm(Model model) {
		List<CategoryList> cList = mService.getCategoryList();
		
		model.addAttribute("cList",cList);
		
		
		return "admin/categoryInsert";
	}
	
	
	
	@PostMapping("/category/insertOrUpdate")
	public String insertOrUpdateCategory(
	    @RequestParam("actionType") String actionType,
	    @RequestParam(value = "categoryNo", required = false, defaultValue = "0") int categoryNo,
	    @RequestParam("hiddenFirstCategory") String firstCategory,
	    @RequestParam("hiddenSecondCategory") String secondCategory,
	    @RequestParam(value = "hiddenThirdCategory", required = false) String thirdCategory,
	    Model model) {

	    try {
	        int result = 0;
	        String cateNo = Integer.toString(categoryNo);
	        CategoryList cList = new CategoryList(cateNo, firstCategory, secondCategory, thirdCategory);
	        
	        if ("insert".equals(actionType)) {
	            result = aService.insertCategory(cList);
	        } else if ("update".equals(actionType)) {
	            if (categoryNo == 0) {
	                model.addAttribute("errorMsg", "수정하려면 categoryNo가 필요합니다.");
	                return "common/error";
	            }
	            result = aService.updateCategory(cList);
	        }

	        if (result > 0) {
	            return "redirect:/category/insert";
	        } else {
	            model.addAttribute("errorMsg", "카테고리 등록/수정 실패");
	            return "common/error";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("errorMsg", e.getMessage());
	        return "common/error";
	    }
	}
	
	
	
	
//	@PostMapping("/category/insert")
//	public String insertCategory(Model model) {
//		int result = aService.registerCategory();
//		if(result >0) {
//			return " ";
//		}else {
//			return "common/error";
//		}
//	}
	
	// 카테고리 수정
	
	// 카테고리 삭제
	
	
	// 재료 등록
//	@GetMapping("/source/insert")
	
	
	// 재료 수정
	
	// 재료 삭제
	
}
