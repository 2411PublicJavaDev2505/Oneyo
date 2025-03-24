package com.oneyo.spring.board.service.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.domain.BoardFileVO;
import com.oneyo.spring.board.service.BFileService;
import com.oneyo.spring.board.store.BFileStore;

@Service
public class BFileServiceImpl implements BFileService {

	private BFileStore fStore;
	private SqlSession session;
	
	@Autowired
	public BFileServiceImpl(BFileStore fStore, SqlSession session) {
		this.fStore = fStore;
		this.session = session;
	}

	@Override
	public int insertBoardFile(BoardFileVO boardFile) {
		return fStore.insertBoardFile(session, boardFile);
	}
	

	

}
