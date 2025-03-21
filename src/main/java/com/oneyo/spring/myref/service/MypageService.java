package com.oneyo.spring.myref.service;

import java.util.List;
import java.util.Map;

import com.oneyo.spring.myref.controller.dto.MySourceList;

public interface MypageService {
	

	List<MySourceList> selectCoolSourceList();

	List<MySourceList> selectIceSourceList();

	List<MySourceList> selectStorageList(Map<String, String> paramMap);

}
