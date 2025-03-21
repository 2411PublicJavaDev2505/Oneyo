package com.oneyo.spring.board.service.impl;

import java.util.List;

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
	public int getTotalCount() {		
		return bStore.getTotalCount(session);
	}

	@Override
	public List<BoardVO> printAllBoardList(int currentPage) {
		return bStore.selectAllBoard(session, currentPage);
	}

	@Override
	public int insertBoard(BoardAddRequest board) {
		return bStore.insertBoard(session, board);
	}

	@Override
	public BoardVO selectOneBoard(int boardNo) {
		return bStore.selectOneBoard(session, boardNo);
	}

}
