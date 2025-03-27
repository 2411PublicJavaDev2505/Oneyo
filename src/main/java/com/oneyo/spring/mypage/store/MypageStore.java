package com.oneyo.spring.mypage.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.board.domain.BoardVO;
import com.oneyo.spring.mypage.domain.MyBoardVO;
import com.oneyo.spring.mypage.domain.MyReplyVO;
import com.oneyo.spring.mypage.domain.MySourceList;

public interface MypageStore {

	List<MySourceList> selectSourceList(SqlSession session);

	List<MyBoardVO> selectBoardList(SqlSession session, String memberId, int currentPage);

	List<MyReplyVO> selectReplyList(SqlSession session, String memberId, int currentPage);

	int getTotalCount(SqlSession session, String memberId);

	List<BoardVO> selectOneByKeyword(SqlSession session, Map<String, String> paramMap, int currentPage);

	int getTotalCount(SqlSession session, Map<String, String> paramMap);

	int deleteReply(SqlSession session, int replyNo);

}
