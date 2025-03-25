package com.oneyo.spring.admin.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.member.domain.MemberVO;

public interface AdminStore {

	/**
	 * 관리자- 회원전체목록 조회
	 * @param session, currentPage
	 * @return List
	 */
	List<MemberVO> selectAllMember(SqlSession session, int currentPage);

	/**
	 * 페이지네이션 (전체목록)
	 * @param session
	 * @return int
	 */
	int selectListCount(SqlSession session);

}
