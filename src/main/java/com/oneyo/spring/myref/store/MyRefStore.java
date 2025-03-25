package com.oneyo.spring.myref.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.myref.controller.dto.CategoryList;
import com.oneyo.spring.myref.controller.dto.CheckLoginRequest;
import com.oneyo.spring.myref.controller.dto.DeleteSource;
import com.oneyo.spring.myref.controller.dto.MySourceList;

public interface MyRefStore {
	
	List<MySourceList> selectCoolSourceList(SqlSession session);
	
	List<MySourceList> selectIceSourceList(SqlSession session);

	List<MySourceList> selectCoolSourceList(SqlSession session, CheckLoginRequest login);

	List<MySourceList> selectIceSourceList(SqlSession session, CheckLoginRequest login);

	List<MySourceList> selectStorageList(SqlSession session, Map<String, String> paramMap);

	List<MySourceList> selectCoolSourceList(SqlSession session, int currentPage, CheckLoginRequest login);

	List<MySourceList> selectIceSourceList(SqlSession session, int currentPage, CheckLoginRequest login);

	int getTotalCount(SqlSession session, CheckLoginRequest login);

	List<CategoryList> getCategoryList(SqlSession session);

	int deleteIceSource(SqlSession session, DeleteSource dSource);

	int deleteCoolSource(SqlSession session, DeleteSource dSource);

}
