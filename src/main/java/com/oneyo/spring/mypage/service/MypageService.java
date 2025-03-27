package com.oneyo.spring.mypage.service;

import java.util.List;
import java.util.Map;

import com.oneyo.spring.board.domain.BoardVO;
import com.oneyo.spring.mypage.domain.MyBoardVO;
import com.oneyo.spring.mypage.domain.MyReplyVO;
import com.oneyo.spring.mypage.domain.MySourceList;

public interface MypageService {

	List<MySourceList> selectSourceList();

	int getTotalCount(String memberId);

	List<MyBoardVO> selectBoardList(String memberId, int currentPage);

	List<MyReplyVO> selectReplyList(String memberId, int currentPage);

	List<BoardVO> selectOneByKeyword(Map<String, String> paramMap, int currentPage);

	int getTotalCount(Map<String, String> paramMap);

	int deleteReply(int replyNo);

	int getTotalBoardCount(String memberId);

}
