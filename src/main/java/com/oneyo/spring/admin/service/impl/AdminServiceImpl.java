package com.oneyo.spring.admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneyo.spring.admin.service.AdminService;
import com.oneyo.spring.admin.store.AdminStore;
import com.oneyo.spring.member.domain.MemberVO;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminStore aStore;
	@Autowired
	private SqlSession session;
	
	public AdminServiceImpl (AdminStore aStore, SqlSession session) {
		this.aStore = aStore;
		this.session = session;		
	}
	
	@Override //회원 전체목록 조회
	public List<MemberVO> selectAllMember(int currentPage) {
		return aStore.selectAllMember(session, currentPage);
	}

	@Override // 페이지네이션(전체조회)
	public int selectListCount() {
		return aStore.selectListCount(session);
	}

}
