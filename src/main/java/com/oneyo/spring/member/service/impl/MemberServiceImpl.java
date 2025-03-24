package com.oneyo.spring.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneyo.spring.member.controller.dto.FindIdRequest;
import com.oneyo.spring.member.controller.dto.JoinRequest;
import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.member.controller.dto.ModifyPasswordRequest;
import com.oneyo.spring.member.controller.dto.ModifyRequest;
import com.oneyo.spring.member.domain.MemberVO;
import com.oneyo.spring.member.service.MemberService;
import com.oneyo.spring.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertMember(JoinRequest member) {
		// TODO Auto-generated method stub
		int result = mStore.insertMember(session, member);
		return result;
	}

	@Override
	public MemberVO selectOneByLogin(LoginRequest member) {
		MemberVO result = mStore.selectOneByLogin(session, member);
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		int result = mStore.deleteMember(session, memberId);
		return result;
	}

	@Override
	public MemberVO selectOneById(String memberId) {
		MemberVO result = mStore.selectOneById(session, memberId);
		return result;
	}

	@Override
	public int modifyMember(ModifyRequest member) {
		int result= mStore.modifyMember(session, member);
		return result;
	}

	@Override
	public int modifyPassword(ModifyPasswordRequest password) {
		int result= mStore.modifyPassword(session, password);
		return result;
	}
}
