package com.oneyo.spring.member.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneyo.spring.member.controller.dto.JoinRequest;
import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.member.domain.MemberVO;
import com.oneyo.spring.member.service.MemberService;
import com.oneyo.spring.member.controller.dto.ModifyRequest;

@Controller
public class MemberController {

	@Autowired
	private MemberService mService;
	
	@RequestMapping(value="/member/main")
	public String showMain(HttpServlet req) {
		return"main";
	}
	@GetMapping("/member/join")
	public String memberjoinForm() {
		return "member/memberJoin";
	}
	@PostMapping("/member/join")
	public String memberJoin(
			@ModelAttribute JoinRequest member
			,HttpServletRequest request, HttpServletResponse response) {
		int result = mService.insertMember(member);
			if(result >0) {
				//성공시 메인페이지 (로그인 페이지) 로 이동
				return "redirect:/";
				
			}else {
				return "common/error";
			}
	}
	
	@GetMapping("/member/login")
	public String memberloginForm() {
		return "member/login";
	}
	@PostMapping("/member/login")
	public String memberLogin(
			@ModelAttribute LoginRequest member,
			HttpSession session,
			Model model) {
		try {
			MemberVO member1 = mService.selectOneByLogin(member);
			if(member1 !=null) {
				session.setAttribute("memberName", member1.getMemberName());
				session.setAttribute("memberId", member1.getMemberId());
				return "redirect:/";
			}else {
				model.addAttribute("errorMsg","존재하지 않는 정보입니다");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
	@GetMapping("/logout")
	public String memberLogout(HttpSession session) {
		if(session !=null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	//계정삭제
	@GetMapping("/delete")
	public String memberDelete(HttpSession session, Model model) {
		try {
			String memberId = (String) session.getAttribute("memberId");
			int result =mService.deleteMember(memberId);
			
			if(result>0) {
				//로그아웃
				return "redirect:/member/logout";
			}else {
				model.addAttribute("errorMsg","존재하지 않는 정보입니다");
				return "common/error";
			}
			
		} catch (Exception e) {
			model.addAttribute("errorMsg",e.getMessage());
			return "error";
		}
	}
	//회원정보수정
	@GetMapping("/member/modify")
	public String memberModifyForm(HttpSession session, Model model) {
		try {
			String memberId = (String) session.getAttribute("memberId");;
			MemberVO member=mService.selectOneById(memberId);
			if(member !=null) {
				model.addAttribute("member", member);
				return "member/modifyMember";
			}else {
				model.addAttribute("errorMsg","존재하지 않는 정보입니다");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	
	@PostMapping("/member/modify")
	public String memberModify(
			@ModelAttribute ModifyRequest member
			,Model model) {
		try {
			int result = mService.modifyMember(member);
			
			if(result>0) {
				return"redirect:/member/mypage";
			}else {
				model.addAttribute("errorMsg","서비스가 완료되지 않았습니다");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg",e.getMessage());
			return "common/error";
		}
	}
	//비밀번호 수정
//	@PostMapping("/member/modifypw")
//	public String passwordModify(
//			 @ModelAttribute ModifyPasswordRequest password,
//			 Model model) {
//		try {
//			int result = mService.modifyPassword(password);
//			if(result>0) {
//				return"redirect:/member/mypage";
//			}else {
//				model.addAttribute("errorMsg","서비스가 완료되지 않았습니다");
//				return "common/error";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();// 콘솔창에 오류 메시지 나오게 하는 명령문
//			model.addAttribute("errorMsg",e.getMessage());
//			return "common/error";
//	
//		}
//	}
	
//	@GetMapping("/member/findid")
//	public String memberfindidForm() {
//		return "member/findId";
//	}
//	@PostMapping("/member/findid")
//	public String memberfindid(
//			@ModelAttribute FindIdRequest memberId,
//			HttpSession session,
//			Model model) {
//		try {
//			MemberVO memberId=mService.findid(memberId);
//			 if (memberId != null) {
//		            model.addAttribute("memberId", memberId);
//		            return "member/findIdResult"; // 결과 페이지로 이동
//		        } else {
//		            model.addAttribute("errorMsg", "존재하지 않는 정보입니다.");
//		            return "common/error";
//		        }
//		    } catch (Exception e) {
//		        model.addAttribute("errorMsg", "예기치 않은 오류가 발생했습니다.");
//		        return "common/error";
//		    }
//	}
	
	
	
	

}
