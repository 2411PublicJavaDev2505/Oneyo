package com.oneyo.spring.myref.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.oneyo.spring.member.controller.dto.LoginRequest;
import com.oneyo.spring.myref.controller.dto.CategoryList;
import com.oneyo.spring.myref.controller.dto.CheckLoginRequest;
import com.oneyo.spring.myref.controller.dto.DeleteSource;
import com.oneyo.spring.myref.controller.dto.MySourceList;
import com.oneyo.spring.myref.service.MyRefService;
import com.oneyo.spring.myref.store.MyRefStore;

@Service
public class MyRefServiceImpl implements MyRefService{
	private MyRefStore mStore;
	private SqlSession session;
	
	public MyRefServiceImpl(MyRefStore mStore, SqlSession session) {
		this.mStore = mStore;
		this.session = session;
		
	}
	
	
	@Override
	public List<MySourceList> selectCoolSourceList() {
		List<MySourceList> cList = mStore.selectCoolSourceList(session);
		return cList;
	}


	@Override
	public List<MySourceList> selectIceSourceList() {
		List<MySourceList> iList = mStore.selectIceSourceList(session);
		return iList;
	}
	
	@Override
	public List<MySourceList> selectCoolSourceList(CheckLoginRequest login) {
		List<MySourceList> mList = mStore.selectCoolSourceList(session, login);
		return mList;
	}
	
	
	@Override
	public List<MySourceList> selectIceSourceList(CheckLoginRequest login) {
		List<MySourceList> iList = mStore.selectIceSourceList(session, login);
		return iList;
	}


	@Override
	public List<MySourceList> selectStorageList(Map<String, String> paramMap) {
		List<MySourceList> storageList = mStore.selectStorageList(session, paramMap);
		return storageList;
	}


	@Override
	public List<MySourceList> selectCoolSourceList(int currentPage, CheckLoginRequest login) {
		List<MySourceList> mList = mStore.selectCoolSourceList(session, currentPage, login);
		return mList;
	}


	@Override
	public List<MySourceList> selectIceSourceList(int currentPage, CheckLoginRequest login) {
		List<MySourceList> iList = mStore.selectIceSourceList(session, currentPage, login);
		return iList;
	}


	@Override
	public int getTotalCount(CheckLoginRequest login) {
		int totalCount = mStore.getTotalCount(session, login);
		return totalCount;
	}


	@Override
	public List<CategoryList> getCategoryList() {
		List<CategoryList> categoryList = mStore.getCategoryList(session);
		return categoryList;
	}


	@Override
	public int deleteIceSource(DeleteSource dSource) {
		int result = mStore.deleteIceSource(session, dSource);
		return result;
	}


	@Override
	public int deleteCoolSource(DeleteSource dSource) {
		int result = mStore.deleteCoolSource(session, dSource);
		return result;
	}




}
