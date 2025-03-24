package com.oneyo.spring.board.service;

import java.util.List;
import java.util.Map;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.controller.dto.BoardUpdateRequest;
import com.oneyo.spring.board.domain.BoardVO;

public interface BoardService {

	/**
	 * 게시글 추가
	 * @param session, board
	 * @return int
	 */
	int insertBoard(BoardAddRequest board);

	/**
	 * 게시글 수정
	 * @param session,board
	 * @return int
	 */
	int updateBoard(BoardUpdateRequest board);

	/**
	 * 게시글 삭제
	 * @param session, boardNo
	 * @return int
	 */
	int deleteBoard(int boardNo);

	/**
	 * 공지사항 목록
	 * @param session
	 * @return List
	 */
	List<BoardVO> printNoticeList();
	/**
	 * 일반게시판 목록
	 * @param session, currentPage
	 * @return List
	 */
	List<BoardVO> printAllBoardList(int currentPage);

	/**
	 * 상세페이지 조회
	 * @param session, boardNo
	 * @return int
	 */
	BoardVO selectOneBoard(int boardNo);

	/**
	 * 공지사항 검색 조회
	 * @param session, paramMap
	 * @return List
	 */
	List<BoardVO> NoticeOneByKeyword(Map<String, String> paramMap);

	/**
	 * 일반게시판 검색 조회
	 * @param session, paramMap, currentPage
	 * @return List
	 */
	List<BoardVO> selectOneByKeyword(Map<String, String> paramMap, int currentPage);

	/**
	 * 페이지네이션(콘텐츠 갯수)
	 * @param session
	 * @return int
	 */
	int getTotalCount();

	/**
	 * 검색 후 페이지네이션
	 * @param session, paramMap
	 * @return int
	 */
	int getTotalCount(Map<String, String> paramMap);

	/**
	 * member테이블에서 닉네임 가져오기
	 * @param session, memberId
	 * @return String
	 */
	String getMemberNickname(String memberId);
	

}
