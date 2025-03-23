package com.oneyo.spring.board.service;

import java.util.List;

import com.oneyo.spring.board.domain.ReplyVO;

public interface ReplyService {

	/**
	 * 댓글 등록
	 * @param session, reply
	 * @return int
	 */
	int insertReply(ReplyVO reply);

	/**
	 * 댓글 삭제
	 * @param session, replyNo
	 * @return int
	 */
	int deleteReply(int replyNo);

	/**
	 * 게시판 상세페이지에 댓글 불러오기
	 * @param session, boardNo
	 * @return List
	 */
	List<ReplyVO> getReplyByBoardNo(int boardNo);

	/**
	 * 아이디를 이용해서 닉네임 출력
	 * @param memberId
	 * @return String
	 */
	String getMemberNickname(String memberId);

}
