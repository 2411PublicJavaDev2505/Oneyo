package com.oneyo.spring.mypage.store.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
	public int getTotalCount(SqlSession session) {
		return session.selectOne("MypageMapper.getTotalCount");
	}

	@Override
	public List<MyBoardVO> selectBoardList(SqlSession session, String memberId, int currentPage) {
		int limit = 5;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("MypageMapper.selectBoardList", memberId, rowBounds);
	}

	@Override
	public List<MyReplyVO> selectReplyList(SqlSession session, String memberId, int currentPage) {
		int limit = 5;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("MypageMapper.selectReplyList", memberId,rowBounds);
	}
	
	

}
