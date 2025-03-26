package com.oneyo.spring.member.store;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.member.controller.dto.FindIdRequest;
import com.oneyo.spring.member.controller.dto.FindPwRequest;
import com.oneyo.spring.member.controller.dto.JoinRequest;
import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.member.controller.dto.ModifyPasswordRequest;
import com.oneyo.spring.member.controller.dto.ModifyRequest;
import com.oneyo.spring.member.domain.MemberVO;

public interface MemberStore {

	int insertMember(SqlSession session, JoinRequest member);

	MemberVO selectOneByLogin(SqlSession session, LoginRequest member);

	int deleteMember(SqlSession session, String memberId);

	MemberVO selectOneById(SqlSession session, String memberId);

	int modifyMember(SqlSession session, ModifyRequest member);

	int modifyPassword(SqlSession session, ModifyPasswordRequest password);

	String findMemberId(SqlSession session, FindIdRequest request);

	MemberVO findMemberPw(SqlSession session, FindPwRequest request);

}
