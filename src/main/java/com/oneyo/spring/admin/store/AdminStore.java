package com.oneyo.spring.admin.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.admin.controller.dto.MemberListRequest;
import com.oneyo.spring.member.domain.MemberVO;
import com.oneyo.spring.myref.controller.dto.CategoryList;

public interface AdminStore {

	/**
	 * 관리자- 회원 삭제
	 * @param session, memberId
	 * @return int
	 */
	int deleteMember(SqlSession session, String memberId);

	/**
	 * 관리자- 회원전체목록 조회
	 * @param session, currentPage
	 * @return List
	 */
	List<MemberVO> selectAllMember(SqlSession session, int currentPage);

	/**
	 * 관리자- 회원검색
	 * @param session, paramMap, currentPage 
	 * @return List
	 */
	List<MemberListRequest> selectOneByKeyword(SqlSession session, Map<String, String> paramMap, int currentPage);

	/**
	 * 페이지네이션 (전체목록)
	 * @param session
	 * @return int
	 */
	int selectListCount(SqlSession session);

	/**
	 * 페이지네이션(검색 후 목록)
	 * @param session, paramMap
	 * @return int
	 */
	int getSearchCount(SqlSession session, Map<String, String> paramMap);


	int updateCategory(SqlSession session, CategoryList cList);

	int insertCategory(SqlSession session, CategoryList cList);

}
