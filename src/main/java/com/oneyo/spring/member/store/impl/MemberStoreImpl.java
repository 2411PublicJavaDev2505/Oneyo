package com.oneyo.spring.member.store.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.member.controller.dto.JoinRequest;
import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.member.controller.dto.ModifyPasswordRequest;
import com.oneyo.spring.member.controller.dto.ModifyRequest;
import com.oneyo.spring.member.domain.MemberVO;
import com.oneyo.spring.member.store.MemberStore;

@Repository
public class MemberStoreImpl implements MemberStore{

	@Override
	public int insertMember(SqlSession session, JoinRequest member) {
		int result = session.insert("MemberMapper.insertMember",member);
		return result;
	}

	@Override
	public MemberVO selectOneByLogin(SqlSession session, LoginRequest member) {
		MemberVO result = session.selectOne("MemberMapper.selectOneByLogin", member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember",memberId);
		return result;
	}

	@Override
	public MemberVO selectOneById(SqlSession session, String memberId) {
		MemberVO result = session.selectOne("MemberMapper.selectOneById",memberId);
		return result;
	}

	@Override
	public int modifyMember(SqlSession session, ModifyRequest member) {
		int result= session.update("MemberMapper.updateMember", member);
		return result;
	}

	@Override
	public int modifyPassword(SqlSession session, ModifyPasswordRequest password) {
		int result= session.update("MemberMapper.updatePassword", password);
		return result;
	}

}
