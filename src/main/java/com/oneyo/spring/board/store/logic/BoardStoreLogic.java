package com.oneyo.spring.board.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.domain.BoardVO;
import com.oneyo.spring.board.store.BoardStore;

@Repository
public class BoardStoreLogic implements BoardStore {

	@Override
	public int getTotalCount(SqlSession session) {
		return session.selectOne("BoardMapper.getTotalCount");
	}

	@Override
	public List<BoardVO> selectAllBoard(SqlSession session, int currentPage) {
		return session.selectList("BoardMapper.selectAllBoard");
	}

	@Override
	public int insertBoard(SqlSession session, BoardAddRequest board) {
		return session.insert("BoardMapper.insertBoard", board);
	}

	@Override
	public BoardVO selectOneBoard(SqlSession session, int boardNo) {
		return session.selectOne("BoardMapper.selectOneBoard", boardNo);
	}

}
