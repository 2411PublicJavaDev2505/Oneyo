package com.oneyo.spring.member.service;

import com.oneyo.spring.member.controller.dto.JoinRequest;
import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.member.controller.dto.ModifyPasswordRequest;
import com.oneyo.spring.member.controller.dto.ModifyRequest;
import com.oneyo.spring.member.domain.MemberVO;

public interface MemberService {
	
	//회원가입
	int insertMember(JoinRequest member);
	//회원 로그인
	MemberVO selectOneByLogin(LoginRequest member);
	//
	int deleteMember(String memberId);
	
	MemberVO selectOneById(String memberId);
	

	int modifyMember(ModifyRequest member);
	
	int modifyPassword(ModifyPasswordRequest password);
	

	
	

	

}
