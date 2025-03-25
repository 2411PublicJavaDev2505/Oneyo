package com.oneyo.spring.mypage.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.mypage.domain.MyBoardVO;
import com.oneyo.spring.mypage.domain.MyReplyVO;
import com.oneyo.spring.mypage.domain.MySourceList;

public interface MypageStore {

	List<MySourceList> selectSourceList(SqlSession session);

	int getTotalCount(SqlSession session);

	List<MyBoardVO> selectBoardList(SqlSession session, String memberId, int currentPage);

	List<MyReplyVO> selectReplyList(SqlSession session, String memberId, int currentPage);

}
