package com.oneyo.spring.mypage.service;

import java.util.List;

import com.oneyo.spring.mypage.domain.MyBoardVO;
import com.oneyo.spring.mypage.domain.MyReplyVO;
import com.oneyo.spring.mypage.domain.MySourceList;

public interface MypageService {

	List<MySourceList> selectSourceList();

	int getTotalCount();

	List<MyBoardVO> selectBoardList(String memberId, int currentPage);

	List<MyReplyVO> selectReplyList(String memberId, int currentPage);

	

	

}
