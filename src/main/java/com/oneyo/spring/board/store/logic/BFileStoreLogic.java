package com.oneyo.spring.board.store.logic;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.board.domain.BoardFileVO;
import com.oneyo.spring.board.store.BFileStore;

@Repository
public class BFileStoreLogic implements BFileStore {

	@Override
	public int insertBoardFile(SqlSession session, BoardFileVO boardFile) {
		return session.insert("BoardFileMapper.insertBoardFile", boardFile);	
	}

}
