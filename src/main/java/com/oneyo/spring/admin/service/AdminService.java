package com.oneyo.spring.admin.service;

import java.util.List;
import java.util.Map;

import com.oneyo.spring.admin.controller.dto.MemberListRequest;
import com.oneyo.spring.member.domain.MemberVO;

public interface AdminService {

	/**
	 * 관리자- 회원 삭제
	 * @param memberId
	 * @return int
	 */
	int deleteMember(String memberId);

	/**
	 * 관리자- 회원전체목록 조회
	 * @param currentPage
	 * @return List
	 */
	List<MemberVO> selectAllMember(int currentPage);

	/**
	 * 관리자- 회원검색목록
	 * @param paramMap
	 * @param currentPage
	 * @return List
	 */
	List<MemberListRequest> selectOneByKeyword(Map<String, String> paramMap, int currentPage);

	/**
	 * 페이지네이션 (전체목록)
	 * @return int
	 */
	int selectListCount();

	/**
	 * 페이지네이션(검색 후 목록)
	 * @param paramMap
	 * @return int
	 */
	int getSearchCount(Map<String, String> paramMap);

}
