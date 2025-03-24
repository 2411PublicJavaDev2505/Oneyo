package com.oneyo.spring.board.store;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.board.domain.BoardFileVO;

public interface BFileStore {

	/**
	 * 첨부파일 등록
	 * @param session, fileInfo
	 * @return int
	 */
	int insertBoardFile(SqlSession session, BoardFileVO boardFile);

}
