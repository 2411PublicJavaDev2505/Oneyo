package com.oneyo.spring.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface BFileService {


	
	void insertBoardFile(MultipartFile uploadFile, String boardNo);

}
