package com.oneyo.spring.member.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oneyo.spring.member.controller.dto.FindIdRequest;
import com.oneyo.spring.member.controller.dto.FindPwRequest;
import com.oneyo.spring.member.controller.dto.JoinRequest;
import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.member.controller.dto.ModifyPasswordRequest;
import com.oneyo.spring.member.domain.MemberVO;
import com.oneyo.spring.member.service.MemberService;
import com.oneyo.spring.member.controller.dto.ModifyRequest;

@Controller
public class MemberController {

	@Autowired
	private MemberService mService;
	
	@RequestMapping(value="/")
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
				//성공시 로그인 페이지로 이동
				return "redirect:/member/login";
				
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
				session.setAttribute("memberNickname", member1.getMemberNickname());
				session.setAttribute("memberPhone", member1.getMemberPhone());
				session.setAttribute("memberId", member1.getMemberId());
				session.setAttribute("member1", member1);
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
	
	@GetMapping("/member/logout")
	public String memberLogout(HttpSession session) {
		if(session !=null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	//계정삭제
	@GetMapping("member/delete")
	public String memberDelete(Model model
			,@RequestParam("memberId") String memberId) {
		System.out.println("Deleting member: " + memberId);
		try {
			int result = mService.deleteMember(memberId);
			if(result > 0) {
				return "redirect:/member/logout";
			}else {
				model.addAttribute("errorMessage","데이터 삭제에 실패하였습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",e.getMessage());
			return "common/error";
		}
	}
	//회원정보수정
	@GetMapping("/member/modify")
	public String memberModifyForm(HttpSession session, Model model) {
        try {
            String memberId = (String) session.getAttribute("memberId");
            if (memberId == null) {
                model.addAttribute("errorMsg", "로그인이 필요합니다.");
                return "common/error";
            }
            
            MemberVO member = mService.selectOneById(memberId);
            if (member != null) {
                model.addAttribute("member", member);
                return "member/modifyMember";  
            } else {
                model.addAttribute("errorMsg", "존재하지 않는 회원 정보입니다.");
                return "common/error";
            }
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "common/error";
        }
    }
	
	@PostMapping("/member/modify")
	  public String memberModify(@ModelAttribute ModifyRequest member, HttpSession session, Model model) {
        try {
            String memberId = (String) session.getAttribute("memberId");
            if (memberId == null) {
                model.addAttribute("errorMsg", "로그인이 필요합니다.");
                return "common/error";
            }

            member.setMemberId(memberId);  
            int result = mService.modifyMember(member);
            
            if (result > 0) {
                return "redirect:/mypage";  
            } else {
                model.addAttribute("errorMsg", "회원 정보 수정에 실패했습니다.");
                return "common/error";
            }
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "common/error";
        }
    }

	@GetMapping("/member/modifypw")
	public String passwordModifyForm(HttpSession session, Model model) {
        try {
            String memberId = (String) session.getAttribute("memberId");
            if (memberId == null) {
                model.addAttribute("errorMsg", "로그인이 필요합니다.");
                return "common/error";
            }

            model.addAttribute("memberId", memberId);
            return "member/modifyMember";  
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "common/error";
        }
    }
	//비밀번호 수정
	@PostMapping("/member/modifypw")
	public String passwordModify(@ModelAttribute ModifyPasswordRequest password, HttpSession session, Model model) {
        try {
            String memberId = (String) session.getAttribute("memberId");
            if (memberId == null) {
                model.addAttribute("errorMsg", "로그인이 필요합니다.");
                return "common/error";
            }

            password.setMemberId(memberId);
            int result = mService.modifyPassword(password);

            if (result > 0) {
                return "redirect:/mypage";  
            } else {
                model.addAttribute("errorMsg", "비밀번호 변경에 실패했습니다.");
                return "common/error";
            }
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "common/error";
        }
    }
	
	@GetMapping("/member/findid")
	public String memberFindIdForm() {
	    return "member/findId";  // 아이디 찾기 폼 페이지로 이동
	}

	@PostMapping("/member/findid")
	public String memberFindId(@ModelAttribute FindIdRequest request,HttpSession session, Model model) {
        try {
            String memberId = mService.findMemberId(request);
            
            if (memberId != null) {
            	session.setAttribute("memberId", memberId);
                return "member/findIdResult";
            } else {
                model.addAttribute("errorMsg", "존재하지 않는 정보입니다.");
                return "common/error";
            }
        } catch (Exception e) {
            model.addAttribute("errorMsg", "예기치 않은 오류가 발생했습니다.");
            return "common/error";
        }
    }
	
	@GetMapping("/member/findIdResult")
	public String memberFindIdResultForm() {
		
	    return "member/findIdResult";  
	}
	
	@GetMapping("/member/findpw")
	public String memberFindpwForm() {
	    return "member/findPw"; 
	}
	@PostMapping("/member/findpw")
	public String memberFindPw(@ModelAttribute FindPwRequest request,HttpSession session, Model model) {
	    try {
	    	 MemberVO member = mService.findMemberPw(request);

	    	 if (member != null) {
	             // 세션에 회원 정보 저장 (비밀번호 변경 시 필요)
	             session.setAttribute("findMember", member);
	             return "redirect:/member/modifypw";
	    	 } else {
	             model.addAttribute("errorMsg", "해당 정보와 일치하는 회원이 없습니다.");
	             return "common/error";
	         }
	     } catch (Exception e) {
	         model.addAttribute("errorMsg", "예기치 않은 오류가 발생했습니다.");
	         return "common/error";
	     }
	 }

	
	
//	@GetMapping("/member/checkDuplicateId")
//    public ResponseEntity<Boolean> checkDuplicateId(@RequestParam String memberId) {
//        boolean isDuplicate = mService.isDuplicateMemberId(memberId);
//        return ResponseEntity.ok(isDuplicate);
//    }
	
	
//	@GetMapping("/member/checkDuplicateNickname")
//    public ResponseEntity<Boolean> checkDuplicateNickName(@RequestParam String memberNickname) {
//        boolean isDuplicate = mService.isDuplicateMemberNickname(memberNickname);
//        return ResponseEntity.ok(isDuplicate);
//    }

}
