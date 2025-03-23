package com.oneyo.spring.board.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.board.domain.ReplyVO;

public interface ReplyStore {

	/**
	 * 댓글 등록
	 * @param session, reply
	 * @return int
	 */
	int insertReply(SqlSession session, ReplyVO reply);

	/**
	 * 댓글 삭제
	 * @param session, replyNo
	 * @return int
	 */
	int deleteReply(SqlSession session, int replyNo);

	/**
	 * 게시판 상세페이지에 댓글 불러오기
	 * @param session, boardNo
	 * @return List
	 */
	List<ReplyVO> getReplyByBoardNo(SqlSession session, int boardNo);

	/**
	 * 아이디를 이용해서 닉네임 출력
	 * @param memberId
	 * @return String
	 */
	String getMemberNickname(SqlSession session, String memberId);

}
