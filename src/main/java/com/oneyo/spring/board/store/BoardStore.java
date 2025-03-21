package com.oneyo.spring.board.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.domain.BoardVO;

public interface BoardStore {

	int getTotalCount(SqlSession session);

	List<BoardVO> selectAllBoard(SqlSession session, int currentPage);

	int insertBoard(SqlSession session, BoardAddRequest board);

	BoardVO selectOneBoard(SqlSession session, int boardNo);

}
