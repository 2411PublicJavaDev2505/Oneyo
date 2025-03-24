package com.oneyo.spring.myref.service;

import java.util.List;
import java.util.Map;

import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.myref.controller.dto.CategoryList;
import com.oneyo.spring.myref.controller.dto.MySourceList;

public interface MyRefService {
	

	List<MySourceList> selectCoolSourceList();
	
	List<MySourceList> selectIceSourceList();
	
	List<MySourceList> selectCoolSourceList(LoginRequest login);

	List<MySourceList> selectIceSourceList(LoginRequest login);

	List<MySourceList> selectStorageList(Map<String, String> paramMap);

	List<MySourceList> selectCoolSourceList(int currentPage);

	List<MySourceList> selectIceSourceList(int currentPage);

	int getTotalCount();

	List<CategoryList> getCategoryList();

}
