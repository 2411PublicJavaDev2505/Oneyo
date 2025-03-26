package com.oneyo.spring.board.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.domain.BoardVO;

public interface BoardStore {

	/**
	 * 게시글 추가
	 * @param session, board
	 * @return int
	 */
	int insertBoard(SqlSession session, BoardAddRequest board);

	/**
	 * 게시글 수정
	 * @param session,board
	 * @return int
	 */
	int updateBoard(SqlSession session, BoardAddRequest board);

	/**
	 * 게시글 삭제
	 * @param session, boardNo
	 * @return int
	 */
	int deleteBoard(SqlSession session, int boardNo);

	/**
	 * 조회수 카운트
	 * @param session
	 * @param boardNo
	 * @return
	 */
	Integer boardCountUpdate(SqlSession session, int boardNo);

	/**
	 * 공지사항 목록
	 * @param session
	 * @return List
	 */
	List<BoardVO> selectNoticeBoard(SqlSession session);
	/**
	 * 일반게시판 목록
	 * @param session, currentPage
	 * @return List
	 */
	List<BoardVO> selectAllBoard(SqlSession session, int currentPage);

	/**
	 * 상세페이지 조회
	 * @param session, boardNo
	 * @return int
	 */
	BoardVO selectOneBoard(SqlSession session, int boardNo);

	/**
	 * 공지사항 검색 조회
	 * @param session, paramMap
	 * @return List
	 */
//	List<BoardVO> NoticeOneByKeyword(SqlSession session, Map<String, String> paramMap);

	/**
	 * 일반게시판 검색 조회
	 * @param session, paramMap, currentPage
	 * @return List
	 */
	List<BoardVO> selectOneByKeyword(SqlSession session, Map<String, String> paramMap, int currentPage);

	/**
	 * 페이지네이션(콘텐츠 갯수)
	 * @param session
	 * @return int
	 */
	int getTotalCount(SqlSession session);

	/**
	 * 검색 후 페이지네이션
	 * @param session, paramMap
	 * @return int
	 */
	int getTotalCount(SqlSession session, Map<String, String> paramMap);

	/**
	 * member테이블에서 닉네임 가져오기
	 * @param memberId
	 * @return String
	 */
	String getMemberNickname(SqlSession session, String memberId);

}
