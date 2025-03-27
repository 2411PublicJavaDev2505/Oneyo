package com.oneyo.spring.myref.service;

import java.util.List;
import java.util.Map;

import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.myref.controller.dto.CategoryList;
import com.oneyo.spring.myref.controller.dto.CheckLoginRequest;
import com.oneyo.spring.myref.controller.dto.DeleteSource;
import com.oneyo.spring.myref.controller.dto.MySourceList;
import com.oneyo.spring.myref.controller.dto.SearchSourceRequest;
import com.oneyo.spring.myref.controller.dto.SourceAddRequest;

public interface MyRefService {
	

	List<MySourceList> selectCoolSourceList();
	
	List<MySourceList> selectIceSourceList();
	
	List<MySourceList> selectCoolSourceList(CheckLoginRequest login);

	List<MySourceList> selectIceSourceList(CheckLoginRequest login);

	List<MySourceList> selectStorageList(Map<String, String> paramMap);

	List<MySourceList> selectCoolSourceList(int currentPage, CheckLoginRequest login);

	List<MySourceList> selectIceSourceList(int currentPage, CheckLoginRequest login);

	int getTotalCount(CheckLoginRequest login);

	List<CategoryList> getCategoryList();

	int deleteIceSource(DeleteSource dSource);

	int deleteCoolSource(DeleteSource dSource);

	int addSource(SourceAddRequest addSource);

	int getSearchCount(SearchSourceRequest searchList);

	List<MySourceList> searchSourceList(int currentPage, SearchSourceRequest searchList);

	//int findDuplicated(SourceAddRequest addSource);
}
