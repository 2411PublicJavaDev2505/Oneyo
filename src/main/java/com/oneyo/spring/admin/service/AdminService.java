package com.oneyo.spring.admin.service;

import java.util.List;

import com.oneyo.spring.member.domain.MemberVO;

public interface AdminService {

	/**
	 * 관리자- 회원전체목록 조회
	 * @param session, currentPage
	 * @return List
	 */
	List<MemberVO> selectAllMember(int currentPage);

	/**
	 * 페이지네이션 (전체목록)
	 * @param session
	 * @return int
	 */
	int selectListCount();

}
