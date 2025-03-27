package com.oneyo.spring.mypage.service.Impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneyo.spring.board.domain.BoardVO;
import com.oneyo.spring.member.store.MemberStore;
import com.oneyo.spring.mypage.domain.MyBoardVO;
import com.oneyo.spring.mypage.domain.MyReplyVO;
import com.oneyo.spring.mypage.domain.MySourceList;
import com.oneyo.spring.mypage.service.MypageService;
import com.oneyo.spring.mypage.store.MypageStore;

@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	private MypageStore mStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public List<MySourceList> selectSourceList() {
		List<MySourceList> mList = mStore.selectSourceList(session);
		return mList;
	}
	@Override
	public List<MyBoardVO> selectBoardList(String memberId, int currentPage) {
		List<MyBoardVO> mList = mStore.selectBoardList(session, memberId,currentPage);
		return mList;
	}
	
	@Override
	public int getTotalCount(String memberId) {
		return mStore.getTotalCount(session,memberId);
	}
	@Override
	public List<MyReplyVO> selectReplyList(String memberId, int currentPage) {
		List<MyReplyVO> rList = mStore.selectReplyList(session, memberId, currentPage);
		return rList;
	}
	
	public List<BoardVO> selectOneByKeyword(Map<String, String> paramMap, int currentPage) {
		List<BoardVO> BList = mStore.selectOneByKeyword(session, paramMap, currentPage);
		return BList;
	}
	@Override
	public int getTotalCount(Map<String, String> paramMap) {
		int result= mStore.getTotalCount(session,paramMap);
		return result;
	}
	@Override
	public int deleteReply(int replyNo) {
		int result= mStore.deleteReply(session, replyNo);
		return result;
	}
	



	

}
