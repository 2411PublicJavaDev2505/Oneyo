package com.oneyo.spring.myref.store.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.myref.controller.dto.CategoryList;
import com.oneyo.spring.myref.controller.dto.MySourceList;
import com.oneyo.spring.myref.store.MyRefStore;

@Repository
public class MyRefStoreImpl implements MyRefStore{

	@Override
	public List<MySourceList> selectCoolSourceList(SqlSession session) {
		List<MySourceList> mList = session.selectList("sourceList.selectCoolSourceList");
		return mList;
	}
	
	@Override
	public List<MySourceList> selectIceSourceList(SqlSession session) {
		List<MySourceList> iList = session.selectList("sourceList.selectIceSourceList");
		return iList;
	}
	
	@Override
	public List<MySourceList> selectCoolSourceList(SqlSession session, LoginRequest login) {
		List<MySourceList> mList = session.selectList("sourceList.selectCoolSourceList");
		return mList;
	}

	@Override
	public List<MySourceList> selectIceSourceList(SqlSession session, LoginRequest login) {
		List<MySourceList> iList = session.selectList("sourceList.selectIceSourceList");
		return iList;
	}

	@Override
	public List<MySourceList> selectStorageList(SqlSession session, Map<String, String> paramMap) {
		List<MySourceList> selectStorage = session.selectList("sourceList.selectStorageList", paramMap);
		System.out.println(selectStorage);
		return selectStorage;
	}

	@Override
	public List<MySourceList> selectCoolSourceList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage -1) * limit;
		RowBounds rowbounds = new RowBounds(offset, limit);
		List<MySourceList> cList = session.selectList("sourceList.selectCoolSourceList", null, rowbounds);
		
		return cList;
	}

	@Override
	public List<MySourceList> selectIceSourceList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage -1) * limit;
		RowBounds rowbounds = new RowBounds(offset, limit);
		List<MySourceList> iList = session.selectList("sourceList.selectIceSourceList", null, rowbounds);
		return iList;
	}

	@Override
	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("sourceList.getTotalCount");
		return totalCount;
	}
	
	
	
	//카테고리 불러올것
	@Override
	public List<CategoryList> getCategoryList(SqlSession session) {
		List<CategoryList> categoryList = session.selectList("category.getCategoryList");
		return categoryList;
	}



}
