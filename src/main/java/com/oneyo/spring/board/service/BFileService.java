package com.oneyo.spring.board.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.domain.BoardFileVO;

@Service
public interface BFileService {

	/**
	 * 첨부파일 등록
	 * @param session, fileInfo
	 * @return int
	 */
	int insertBoardFile(BoardFileVO boardFile);



}
