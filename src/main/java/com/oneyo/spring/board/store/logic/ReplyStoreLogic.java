package com.oneyo.spring.board.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.board.domain.ReplyVO;
import com.oneyo.spring.board.store.ReplyStore;

@Repository
public class ReplyStoreLogic implements ReplyStore {

	@Override
	public int insertReply(SqlSession session, ReplyVO reply) {
		return session.insert("ReplyMapper.insertReply", reply);
	}

	@Override
	public int deleteReply(SqlSession session, int replyNo) {
		return session.delete("ReplyMapper.deleteReply", replyNo);
	}

	@Override
	public List<ReplyVO> getReplyByBoardNo(SqlSession session, int boardNo) {
		return session.selectList("ReplyMapper.getReplyByBoardNo",boardNo);
	}

	@Override
	public String getMemberNickname(SqlSession session, String memberId) {
		return session.selectOne("ReplyMapper.getMemberNickname",memberId);
	}

}
