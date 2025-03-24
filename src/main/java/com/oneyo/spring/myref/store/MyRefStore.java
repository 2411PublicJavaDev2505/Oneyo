package com.oneyo.spring.myref.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.myref.controller.dto.CategoryList;
import com.oneyo.spring.myref.controller.dto.MySourceList;

public interface MyRefStore {
	
	List<MySourceList> selectCoolSourceList(SqlSession session);
	
	List<MySourceList> selectIceSourceList(SqlSession session);

	List<MySourceList> selectCoolSourceList(SqlSession session, LoginRequest login);

	List<MySourceList> selectIceSourceList(SqlSession session, LoginRequest login);

	List<MySourceList> selectStorageList(SqlSession session, Map<String, String> paramMap);

	List<MySourceList> selectCoolSourceList(SqlSession session, int currentPage);

	List<MySourceList> selectIceSourceList(SqlSession session, int currentPage);

	int getTotalCount(SqlSession session);

	List<CategoryList> getCategoryList(SqlSession session);


}
