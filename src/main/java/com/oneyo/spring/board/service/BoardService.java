package com.oneyo.spring.board.service;

import java.util.List;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.domain.BoardVO;

public interface BoardService {

	int getTotalCount();

	List<BoardVO> printAllBoardList(int currentPage);

	int insertBoard(BoardAddRequest board);

	BoardVO selectOneBoard(int boardNo);

}
