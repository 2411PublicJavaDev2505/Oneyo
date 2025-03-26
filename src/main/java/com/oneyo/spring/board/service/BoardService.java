package com.oneyo.spring.board.service;

import java.util.List;
import java.util.Map;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.domain.BoardVO;

public interface BoardService {

	/**
	 * 게시글 추가
	 * @param board
	 * @return int
	 */
	int insertBoard(BoardAddRequest board);

	/**
	 * 게시글 수정
	 * @param board
	 * @return int
	 */
	int updateBoard(BoardAddRequest board);

	/**
	 * 게시글 삭제
	 * @param boardNo
	 * @return int
	 */
	int deleteBoard(int boardNo);

	/**
	 * 조회수 카운트
	 * @param boardNo
	 * @return
	 */
	Integer boardCountUpdate(int boardNo);

	/**
	 * 공지사항 목록
	 * @return List
	 */
	List<BoardVO> printNoticeList();
	/**
	 * 일반게시판 목록
	 * @param currentPage
	 * @return List
	 */
	List<BoardVO> printAllBoardList(int currentPage);

	/**
	 * 상세페이지 조회
	 * @param boardNo
	 * @return int
	 */
	BoardVO selectOneBoard(int boardNo);

	/**
	 * 공지사항 검색 조회
	 * @param paramMap
	 * @return List
	 */
//	List<BoardVO> NoticeOneByKeyword(Map<String, String> paramMap);

	/**
	 * 일반게시판 검색 조회
	 * @param paramMap, currentPage
	 * @return List
	 */
	List<BoardVO> selectOneByKeyword(Map<String, String> paramMap, int currentPage);

	/**
	 * 페이지네이션(콘텐츠 갯수)
	 * @param 
	 * @return int
	 */
	int getTotalCount();

	/**
	 * 검색 후 페이지네이션
	 * @param paramMap
	 * @return int
	 */
	int getTotalCount(Map<String, String> paramMap);

	/**
	 * member테이블에서 닉네임 가져오기
	 * @param memberId
	 * @return String
	 */
	String getMemberNickname(String memberId);
	

}
