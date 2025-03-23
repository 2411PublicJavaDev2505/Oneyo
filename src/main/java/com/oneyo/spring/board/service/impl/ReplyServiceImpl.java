package com.oneyo.spring.board.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneyo.spring.board.domain.ReplyVO;
import com.oneyo.spring.board.service.ReplyService;
import com.oneyo.spring.board.store.ReplyStore;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyStore rStore;
	private SqlSession session;
	
	@Autowired
	public ReplyServiceImpl(ReplyStore rStore, SqlSession session) {
		this.rStore = rStore;
		this.session = session;
	}

	@Override
	public int insertReply(ReplyVO reply) {
		return rStore.insertReply(session, reply);
	}

	@Override
	public int deleteReply(int replyNo) {
		return rStore.deleteReply(session, replyNo);
	}

	@Override
	public List<ReplyVO> getReplyByBoardNo(int boardNo) {
		return rStore.getReplyByBoardNo(session, boardNo);
	}

	@Override
	public String getMemberNickname(String memberId) {
		return rStore.getMemberNickname(session, memberId);
	}

}
