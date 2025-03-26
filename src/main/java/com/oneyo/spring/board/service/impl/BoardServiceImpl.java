package com.oneyo.spring.board.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.domain.BoardVO;
import com.oneyo.spring.board.service.BoardService;
import com.oneyo.spring.board.store.BoardStore;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardStore bStore;
	private SqlSession session;
	
	@Autowired
	public BoardServiceImpl(BoardStore bStore, SqlSession session) {
		this.bStore = bStore;
		this.session = session;
	}
	
	@Override
	public int insertBoard(BoardAddRequest board) {
		return bStore.insertBoard(session, board);
	}

	@Override
	public int updateBoard(BoardAddRequest board) {
		return bStore.updateBoard(session, board);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return bStore.deleteBoard(session, boardNo);
	}

	@Override
	public Integer boardCountUpdate(int boardNo) {
		return bStore.boardCountUpdate(session, boardNo);
	}

	@Override
	public List<BoardVO> printNoticeList() {
		return bStore.selectNoticeBoard(session);
	}

	@Override
	public List<BoardVO> printAllBoardList(int currentPage) {
		return bStore.selectAllBoard(session, currentPage);
	}

	@Override
	public BoardVO selectOneBoard(int boardNo) {
		return bStore.selectOneBoard(session, boardNo);
	}

//	@Override
//	public List<BoardVO> NoticeOneByKeyword(Map<String, String> paramMap) {
//		return bStore.NoticeOneByKeyword(session, paramMap);
//	}

	@Override
	public List<BoardVO> selectOneByKeyword(Map<String, String> paramMap, int currentPage) {
		return bStore.selectOneByKeyword(session, paramMap, currentPage);
	}

	@Override
	public int getTotalCount() {		
		return bStore.getTotalCount(session);
	}

	@Override
	public int getTotalCount(Map<String, String> paramMap) {
		return bStore.getTotalCount(session, paramMap);
	}

	@Override
	public String getMemberNickname(String memberId) {
		return bStore.getMemberNickname(session, memberId);
	}

}
