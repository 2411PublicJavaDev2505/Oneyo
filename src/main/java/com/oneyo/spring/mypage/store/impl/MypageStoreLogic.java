package com.oneyo.spring.mypage.store.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.board.domain.BoardVO;
import com.oneyo.spring.mypage.domain.MyBoardVO;
import com.oneyo.spring.mypage.domain.MyReplyVO;
import com.oneyo.spring.mypage.domain.MySourceList;
import com.oneyo.spring.mypage.store.MypageStore;

@Repository
public class MypageStoreLogic implements MypageStore{

	@Override
	public List<MySourceList> selectSourceList(SqlSession session) {
		List<MySourceList> mList = session.selectList("mySourceList.selectSourceList");
		return mList;
	}

	@Override
	public int getTotalCount(SqlSession session, String memberId) {
		return session.selectOne("MypageMapper.getTotalCount",memberId);
	}

	@Override
	public List<MyBoardVO> selectBoardList(SqlSession session, String memberId, int currentPage) {
		int limit = 7;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("MypageMapper.selectBoardList", memberId, rowBounds);
	}

	@Override
	public List<MyReplyVO> selectReplyList(SqlSession session, String memberId, int currentPage) {
		int limit = 7;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("MypageMapper.selectReplyList", memberId,rowBounds);
	}

	@Override
	public List<BoardVO> selectOneByKeyword(SqlSession session, Map<String, String> paramMap, int currentPage) {
		int limit = 7;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("BoardMapper.selectOneByKeyword", paramMap, rowBounds);
	}

	@Override
	public int getTotalCount(SqlSession session, Map<String, String> paramMap) {
		return session.selectOne("MypageMapper.getSearchCount",paramMap);
	}

	@Override
	public int deleteReply(SqlSession session, int replyNo) {
		return session.delete("MypageMapper.deleteReply",replyNo);
	}
	
	

}
